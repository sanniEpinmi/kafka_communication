package com.sanni.michael.consumer.service;

import com.sanni.michael.consumer.domain.Transaction;
import com.sanni.michael.consumer.domain.dto.TransactionDto;
import com.sanni.michael.consumer.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void persistTransaction(Transaction transaction) {
        Transaction persistedTransaction = transactionRepository.save(transaction);

        log.info("Transaction  persisted {}", persistedTransaction);



    }

}
