package com.ibercode.customer.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerMetadata {

    @JsonProperty("correlationId")
    private String correlationId = null;

    public CustomerMetadata() {
    }

    public CustomerMetadata(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
