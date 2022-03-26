package com.ibercode.payments.model;

public class Data {
    private String customerId;
    private String customerFullName;
    private String customerEmail;
    private String amount;
    private String product;

    public Data(String customerId, String customerFullName, String customerEmail, String amount, String product) {
        this.customerId = customerId;
        this.customerFullName = customerFullName;
        this.customerEmail = customerEmail;
        this.amount = amount;
        this.product = product;
    }
}

