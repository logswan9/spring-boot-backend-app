package com.example.demo.controllers;

import com.example.demo.dao.*;
import com.example.demo.entities.*;
import com.example.demo.services.CheckoutServiceImpl;
import com.example.demo.services.PurchaseData;
import com.example.demo.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CheckoutController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    VacationRepository vacationRepository;
    @Autowired
    ExcursionRepository excursionRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemRepository cartItemRepository;


    @PostMapping("api/checkout/purchase")
    @ResponseBody
    public ResponseEntity<String> makePurchase(@RequestBody Map<String,Object> body) {
        Map<String,Object> customerJSON = (Map<String, Object>) body.get("customer");
        Map<String,Object> cartJSON = (Map<String, Object>) body.get("cart");
        List<Object> cartItemsJSON = (List<Object>) body.get("cartItems");


        PurchaseResponse purchaseResponse = new PurchaseResponse();


        Optional<Customer> customerOpt = customerRepository.findById(Long.valueOf((Integer) customerJSON.get("id")));
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();

            Cart cart = new Cart();
            try {
                cart.setPackage_price(BigDecimal.valueOf(Long.valueOf(cartJSON.get("package_price").toString())));
                cart.setParty_size((Integer) cartJSON.get("party_size"));
                cart.setStatus(StatusType.valueOf(cartJSON.get("status").toString()));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Cart data is not valid!");
            }

            cart.setCustomer(customer);
            cart.setOrderTrackingNumber(purchaseResponse.getOrderTrackingNumber());



            List<CartItem> cartItemList = new ArrayList<>();

            if (cartItemsJSON.size() > 0) {
                for (Object o: cartItemsJSON) {
                    Map<String,Object> cartItemObj;
                    CartItem cartItem = new CartItem();
                    Map<String, Object> vacationObj;
                    try {
                        cartItemObj = (Map<String, Object>) o;
                        vacationObj = (Map<String, Object>) cartItemObj.get("vacation");
                    } catch (Exception e) {
                        return ResponseEntity.badRequest().body("Cart item data is not valid!");
                    }

                    Optional<Vacation> vacationOpt = vacationRepository.findById(Long.valueOf(vacationObj.get("id").toString()));

                    if (vacationOpt.isPresent()) {
                        Vacation vacation = vacationOpt.get();
                        List<Excursion> vacationExcursionList = new ArrayList<>();


                        List<Object> cartItemExcursionsObj = (List<Object>) cartItemObj.get("excursions");
                        if (cartItemExcursionsObj != null) {
                            for (Object cObj: cartItemExcursionsObj) {
                                Map<String,Object> excursionObj = (Map<String, Object>) cObj;
                                Optional<Excursion> excursionOpt = excursionRepository.findById(Long.valueOf(excursionObj.get("id").toString()));
                                if (excursionOpt.isPresent()) {
                                    Excursion excursion = excursionOpt.get();
                                    vacationExcursionList.add(excursion);
                                } else {
                                    return ResponseEntity.badRequest().body("Excursion does not exist!");
                                }
                            }
                        } else {
                            return ResponseEntity.badRequest().body("Excursion data is not valid!");
                        }


                        Set<Excursion> eHashSet = new HashSet<>(vacationExcursionList);
                        vacation.setExcursions(eHashSet);

                        cartItem.setCart(cart);
                        cartItem.setVacation(vacation);
                        cartItem.setExcursions(vacation.getExcursions());
                        cartItemList.add(cartItem);

                    } else {
                        return ResponseEntity.badRequest().body("Chosen Vacation does not exist!");
                    }

                }
            } else {
                return ResponseEntity.badRequest().body("Cart item data is not valid!");
            }


            Set<CartItem> cartItems = new HashSet<>(cartItemList);

            PurchaseData purchaseData = new PurchaseData(customer, cart, cartItems);

            CheckoutServiceImpl checkoutService = new CheckoutServiceImpl(cartRepository, cartItemRepository);

            checkoutService.save(purchaseData);


        } else {
            return ResponseEntity.badRequest().body("Customer does not exist!");
        }



        return  ResponseEntity.accepted().body("{\"orderTrackingNumber\": \"" + purchaseResponse.getOrderTrackingNumber() + "\"}");
    }

}
