package com.ibercode.payments.utils;

import com.google.gson.Gson;
import com.ibercode.payments.model.PaymentCreated;
import software.amazon.awssdk.core.SdkSystemSetting;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.eventbridge.EventBridgeClient;
import software.amazon.awssdk.services.eventbridge.model.PutEventsRequest;
import software.amazon.awssdk.services.eventbridge.model.PutEventsRequestEntry;
import software.amazon.awssdk.services.eventbridge.model.PutEventsResponse;

public class EventsUtils {

    private final Gson GSON = new Gson();
    private final EventBridgeClient eventBrClient = EventBridgeClient.builder()
            .region(Region.of(System.getenv(SdkSystemSetting.AWS_REGION.environmentVariable())))
            .build();

    public String publishCustomerEvent(PaymentCreated payment, String eventBusName, String source, String detailType) {

            PutEventsRequestEntry requestEntry = PutEventsRequestEntry.builder()
                    .source(source)
                    .detailType(detailType)
                    .detail(GSON.toJson(payment))
                    .eventBusName(eventBusName)
                    .build();

            PutEventsRequest eventsRequest = PutEventsRequest.builder()
                    .entries(requestEntry)
                    .build();

            PutEventsResponse result = eventBrClient.putEvents(eventsRequest);

            return result.entries().get(0).eventId();
    }
}
