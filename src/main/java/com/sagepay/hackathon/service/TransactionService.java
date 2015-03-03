package com.sagepay.hackathon.service;

import com.sagepay.hackathon.model.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactionsFromRegion(String region);
    List<Transaction> getTransactionsFromRegionForPeriod(String region, Date begin, Date end);

}
