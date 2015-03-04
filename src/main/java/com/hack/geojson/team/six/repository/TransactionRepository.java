package com.hack.geojson.team.six.repository;

import com.hack.geojson.team.six.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    public List<Transaction> findByLocationRegion(String region);
    public List<Transaction> findByLocationRegionAndDateBetween(String region, Date begin, Date end);
}
