package com.sanni.michael.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sanni.michael.producer.domain.Transaction;
import com.sanni.michael.producer.service.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionService {

    private final Producer producer;

    @Autowired
    public TransactionService(Producer producer) {
        this.producer = producer;
    }

    public String createTransaction(Transaction transaction) throws JsonProcessingException {
        return producer.sendMessage(transaction);
    }
}
