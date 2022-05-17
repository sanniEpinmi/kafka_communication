package com.sanni.michael.producer.domain;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Transaction {
    String item;
    Double amount;
    String transactionId;
    String customerId;
    String status;
}
