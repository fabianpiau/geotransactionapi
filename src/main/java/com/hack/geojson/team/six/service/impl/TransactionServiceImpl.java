package com.hack.geojson.team.six.service.impl;

import com.hack.geojson.team.six.model.Transaction;
import com.hack.geojson.team.six.repository.TransactionRepository;
import com.hack.geojson.team.six.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getTransactionsFromRegion(String region) {
        return transactionRepository.findByLocationRegion(region);
    }

    @Override
    public List<Transaction> getTransactionsFromRegionForPeriod(String region, Date begin, Date end) {
        return transactionRepository.findByLocationRegionAndDateBetween(region, begin, end);
    }
}
