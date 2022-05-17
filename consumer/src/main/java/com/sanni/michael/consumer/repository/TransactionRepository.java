package com.sanni.michael.consumer.repository;

import com.sanni.michael.consumer.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(
            value = "SELECT * FROM Transaction  WHERE status is null ",
            nativeQuery = true)
    public List<Transaction> la ();
}
