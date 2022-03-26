package com.ibercode.customer.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CustomerData implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("customerId")
    private String customerId = null;
    @JsonProperty("customerFullName")
    private String customerFullName = null;
    @JsonProperty("customerEmail")
    private String customerEmail = null;
    @JsonProperty("amount")
    private String amount = null;
    @JsonProperty("product")
    private String product = null;

    public CustomerData() {
    }

    public CustomerData(String customerId, String customerFullName, String customerEmail, String amount, String product) {
        this.customerId = customerId;
        this.customerFullName = customerFullName;
        this.customerEmail = customerEmail;
        this.amount = amount;
        this.product = product;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}

