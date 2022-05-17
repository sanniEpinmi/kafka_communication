package com.sanni.michael.consumer.service;

import com.sanni.michael.consumer.domain.Transaction;
import com.sanni.michael.consumer.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class SchedulerService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public SchedulerService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }





    @Scheduled(fixedDelay = 100000)
    public void schedularMsgConsumeKakfa() throws Exception {
        List<Transaction> allListNoStatus  =transactionRepository.la();
     for (Transaction t : allListNoStatus){
         t.setStatus("success");
         transactionRepository.save(t);
     }

    }

    }