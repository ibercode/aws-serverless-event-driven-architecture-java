package com.ibercode.sales.utils;

import com.google.gson.Gson;
import com.ibercode.sales.model.ddb.SalesPaymentItem;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.core.SdkSystemSetting;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.UUID;

public class SalesDDBUtils {
    private final Gson gson = new Gson();
    private final DynamoDbClient ddb = DynamoDbClient.builder()
            .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
            .region(Region.of(System.getenv(SdkSystemSetting.AWS_REGION.environmentVariable())))
            .build();
    private final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(ddb)
            .build();

    public String putItem(String body, String tableName) {

        DynamoDbTable<SalesPaymentItem> mappedTable = enhancedClient
                .table(tableName, TableSchema.fromBean(SalesPaymentItem.class));

        String paymentId = UUID.randomUUID().toString();

        SalesPaymentItem payment = gson.fromJson(body, SalesPaymentItem.class);

        payment.setSaleId(paymentId);

        mappedTable.putItem(payment);

        return paymentId;
    }
}
