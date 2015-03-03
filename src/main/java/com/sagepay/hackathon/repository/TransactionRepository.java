package com.sagepay.hackathon.repository;

import com.sagepay.hackathon.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    public List<Transaction> findByLocationRegion(String region);
}
