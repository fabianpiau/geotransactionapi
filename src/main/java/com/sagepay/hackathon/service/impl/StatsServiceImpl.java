package com.sagepay.hackathon.service.impl;

import com.sagepay.hackathon.model.Location;
import com.sagepay.hackathon.model.RegionTransactionStat;
import com.sagepay.hackathon.model.Transaction;
import com.sagepay.hackathon.service.LocationService;
import com.sagepay.hackathon.service.StatsService;
import com.sagepay.hackathon.service.TransactionService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    public static final String SCOTLAND_REGION_NAME = "Scotland";
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private LocationService locationService;

    @Override
    public List<RegionTransactionStat> getAggregatedTransactionsPerRegion() {
        List<RegionTransactionStat> regionTransactionStats = new ArrayList<RegionTransactionStat>();
        List<Location> locations = locationService.getAllLocations();
        for (Location location : locations) {
            String region = location.getRegion();
            RegionTransactionStat statScotland = isScotlandAlreadyInStats(regionTransactionStats);
            if (region.equalsIgnoreCase(SCOTLAND_REGION_NAME) && statScotland != null) {
                updateStatsForScotland(region, statScotland);
            } else {
                RegionTransactionStat regionTransactionStat = new RegionTransactionStat();
                regionTransactionStat.setRegion(region);
                List<Transaction> transactions = transactionService.getTransactionsFromRegion(region);
                regionTransactionStat.setNbTransactions(transactions.size());
                regionTransactionStat.setTotalAmount(getTotalAmountForTransactions(transactions));
                regionTransactionStats.add(regionTransactionStat);
            }
        }
        return regionTransactionStats;
    }


    private Integer getTotalAmountForTransactions(List<Transaction> transactions) {
        Integer totalAmount = 0;
        for (Transaction transaction : transactions) {
            totalAmount += transaction.getAmount();
        }
        return totalAmount;
    }

    private void updateStatsForScotland(String region, RegionTransactionStat regionTransactionStats) {
        List<Transaction> transactions = transactionService.getTransactionsFromRegion(region);
        regionTransactionStats.setTotalAmount(regionTransactionStats.getTotalAmount() + getTotalAmountForTransactions(transactions));
        regionTransactionStats.setNbTransactions(regionTransactionStats.getNbTransactions() + transactions.size());
    }

    private RegionTransactionStat isScotlandAlreadyInStats(List<RegionTransactionStat> regionTransactionStats) {
        return (RegionTransactionStat) CollectionUtils.find(regionTransactionStats, new Predicate() {
            @Override
            public boolean evaluate(Object regionTransactionStat) {
                return ((RegionTransactionStat) regionTransactionStat).getRegion().equalsIgnoreCase(SCOTLAND_REGION_NAME);
            }
        });
    }

}
