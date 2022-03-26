package com.ibercode.sales.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SalesPayment implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private SalesData data = null;
    @JsonProperty("metadata")
    private SalesMetadata metadata = null;

    public SalesPayment() {
    }

    public SalesPayment(SalesData data, SalesMetadata metadata) {
        this.data = data;
        this.metadata = metadata;
    }

    public SalesData getData() {
        return data;
    }

    public void setData(SalesData data) {
        this.data = data;
    }

    public SalesMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(SalesMetadata metadata) {
        this.metadata = metadata;
    }
}
