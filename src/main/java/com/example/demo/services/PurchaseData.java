package com.example.demo.services;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;

import java.util.HashSet;
import java.util.Set;

public class PurchaseData {

    Customer customer = new Customer();

    Cart cart = new Cart();

    Set<CartItem> cartItems = new HashSet<>();

    public PurchaseData() {}

    public PurchaseData(Customer customer, Cart cart, Set<CartItem> cartItems) {
        this.customer = customer;
        this.cart = cart;
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
