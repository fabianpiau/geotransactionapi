package com.sagepay.hackathon.service.impl;

import com.sagepay.hackathon.model.Transaction;
import com.sagepay.hackathon.repository.TransactionRepository;
import com.sagepay.hackathon.service.TransactionService;
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
