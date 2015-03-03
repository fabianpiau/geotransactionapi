package com.sagepay.hackaton.repository;

import com.sagepay.hackaton.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    public List<Transaction> findByLocationRegion(String region);
}
