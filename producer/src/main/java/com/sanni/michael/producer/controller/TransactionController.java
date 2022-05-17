package com.sanni.michael.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sanni.michael.producer.domain.Transaction;
import com.sanni.michael.producer.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public String createFoodOrder(@RequestBody Transaction transaction) throws JsonProcessingException {
        log.info("create transction request received");
        return transactionService.createTransaction(transaction);
    }
}
