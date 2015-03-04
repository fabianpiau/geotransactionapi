package com.hack.geojson.team.six.service;

import com.hack.geojson.team.six.model.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactionsFromRegion(String region);
    List<Transaction> getTransactionsFromRegionForPeriod(String region, Date begin, Date end);

}
