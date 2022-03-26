package com.ibercode.sales.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SalesMetadata implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("correlationId")
    private String correlationId = null;

    public SalesMetadata() {
    }

    public SalesMetadata(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
