package com.ibercode.payments;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.ibercode.payments.model.Data;
import com.ibercode.payments.model.Metadata;
import com.ibercode.payments.model.PaymentCreated;
import com.ibercode.payments.utils.EventsUtils;

import java.util.UUID;

public class Payments implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final Gson GSON = new Gson();
    private final EventsUtils eventsUtils = new EventsUtils();
    private APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {

        String EVENT_BUS = System.getenv("EVENT_BUS_NAME");

        Data data = GSON.fromJson(event.getBody(), Data.class);
        Metadata metadata = new Metadata(UUID.randomUUID().toString());
        PaymentCreated payment = new PaymentCreated(data, metadata);

        eventsUtils.publishCustomerEvent(payment, EVENT_BUS,"com.ibercode.payments", "customer");
        eventsUtils.publishCustomerEvent(payment, EVENT_BUS,"com.ibercode.payments", "sales");
        eventsUtils.publishCustomerEvent(payment, EVENT_BUS,"com.ibercode.payments", "email");

        response.setBody("Payment submitted!");

        return response;
    }

}
