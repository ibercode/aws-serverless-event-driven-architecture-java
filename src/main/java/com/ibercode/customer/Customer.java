package com.ibercode.customer;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.Gson;
import com.ibercode.customer.model.event.AWSEvent;
import com.ibercode.customer.model.event.CustomerPayment;
import com.ibercode.customer.model.event.Marshaller;
import com.ibercode.customer.utils.CustomerDDBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Customer implements RequestStreamHandler {
    private CustomerDDBUtils ddbUtils = new CustomerDDBUtils();
    private Gson GSON = new Gson();
    private final String CUSTOMER_TABLE = System.getenv("CUSTOMER_TABLE");
    private final Logger LOGGER = LoggerFactory.getLogger(Customer.class);

    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

        AWSEvent<CustomerPayment> event = Marshaller.unmarshalEvent(input, CustomerPayment.class);

        CustomerPayment payment = event.getDetail();

        String itemId = ddbUtils.putItem(GSON.toJson(payment.getData()), CUSTOMER_TABLE);
        LOGGER.info("[item ID]" + itemId);
    }
}