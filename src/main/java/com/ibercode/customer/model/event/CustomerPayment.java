package com.ibercode.customer.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CustomerPayment implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private CustomerData data = null;
    @JsonProperty("metadata")
    private CustomerMetadata metadata = null;

    public CustomerPayment() {
    }

    public CustomerPayment(CustomerData data, CustomerMetadata metadata) {
        this.data = data;
        this.metadata = metadata;
    }

    public CustomerData getData() {
        return data;
    }

    public void setData(CustomerData data) {
        this.data = data;
    }

    public CustomerMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CustomerMetadata metadata) {
        this.metadata = metadata;
    }
}
