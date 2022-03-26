package com.ibercode.sales;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.Gson;
import com.ibercode.customer.Customer;
import com.ibercode.sales.model.event.AWSEvent;
import com.ibercode.sales.model.event.Marshaller;
import com.ibercode.sales.model.event.SalesPayment;
import com.ibercode.sales.utils.SalesDDBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Sales implements RequestStreamHandler {

    private final SalesDDBUtils ddbUtils = new SalesDDBUtils();
    private final String SALES_TABLE = System.getenv("SALES_TABLE");
    private final Gson GSON = new Gson();
    private final Logger LOGGER = LoggerFactory.getLogger(Customer.class);

    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

        AWSEvent<SalesPayment> event = Marshaller.unmarshalEvent(input, SalesPayment.class);

        SalesPayment payment = event.getDetail();

        String itemId = ddbUtils.putItem(GSON.toJson(payment.getData()), SALES_TABLE);

        LOGGER.info("[item ID]" + itemId);
    }
}
