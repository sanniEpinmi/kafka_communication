package com.sanni.michael.consumer.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanni.michael.consumer.domain.Transaction;
import com.sanni.michael.consumer.domain.dto.TransactionDto;
import com.sanni.michael.consumer.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class Consumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final TransactionService transactionService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, TransactionService transactionService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.transactionService = transactionService;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        TransactionDto transactionDto = objectMapper.readValue(message, TransactionDto.class);
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
             // saves  the record to database
        transactionService.persistTransaction(transaction);




    }

}
