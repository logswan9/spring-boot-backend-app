package com.example.demo.services;

import java.util.Random;

public class PurchaseResponse {

    String orderTrackingNumber;

    public PurchaseResponse() {
        this.orderTrackingNumber = generateOrderTrackingNumber();
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String val) {
        this.orderTrackingNumber = val;
    }

    public String generateOrderTrackingNumber() {
        String vals = "abcdefghijklmnopqrstuvwxyz0123456789"; //0-35
        StringBuilder trackNum = new StringBuilder();
        Random rand = new Random();

        while (trackNum.length() < 10) {
            trackNum.append(vals.charAt(rand.nextInt(36)));
        }

        return trackNum.toString();
    }

}
