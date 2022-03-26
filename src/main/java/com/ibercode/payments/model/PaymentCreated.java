package com.ibercode.payments.model;

public class PaymentCreated {

    private Data data;
    private Metadata metadata;

    public PaymentCreated(Data data, Metadata metadata) {
        this.data = data;
        this.metadata = metadata;
    }
}
