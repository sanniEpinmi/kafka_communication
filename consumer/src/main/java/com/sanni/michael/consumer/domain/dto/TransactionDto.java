package com.sanni.michael.consumer.domain.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class TransactionDto {
    String transactionId;
    String customerId;
    String status;
    String item;
    Double amount;
  
}
