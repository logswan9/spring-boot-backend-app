package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    public void save(PurchaseData purchaseData) {
        cartRepository.save(purchaseData.cart);
        for (CartItem c: purchaseData.cartItems) {
            cartItemRepository.save(c);
        }

    }
}
