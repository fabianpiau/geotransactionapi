package com.sagepay.hackathon.service.impl;

import com.sagepay.hackathon.model.Location;
import com.sagepay.hackathon.model.RegionTransactionStat;
import com.sagepay.hackathon.model.Transaction;
import com.sagepay.hackathon.service.LocationService;
import com.sagepay.hackathon.service.StatsService;
import com.sagepay.hackathon.service.TransactionService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private LocationService locationService;

    @Override
    public List<RegionTransactionStat> getAggregatedTransactionsPerRegion(Date begin, Date end) {
        List<RegionTransactionStat> regionTransactionStats = new ArrayList<RegionTransactionStat>();
        List<Location> locations = locationService.getAllLocations();
        for (Location location : locations) {
            String region = location.getRegion();
            RegionTransactionStat statForRegion = isRegionAlreadyInStats(regionTransactionStats, region);
            if (statForRegion != null) {
                updateStatsForRegion(region, statForRegion, begin, end);
            } else {
                RegionTransactionStat regionTransactionStat = new RegionTransactionStat();
                regionTransactionStat.setRegion(region);
                List<Transaction> transactions = transactionService.getTransactionsFromRegionForPeriod(region, begin, end);
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

    private void updateStatsForRegion(String region, RegionTransactionStat regionTransactionStats, Date begin, Date end) {
        List<Transaction> transactions = transactionService.getTransactionsFromRegionForPeriod(region, begin, end);
        regionTransactionStats.setTotalAmount(regionTransactionStats.getTotalAmount() + getTotalAmountForTransactions(transactions));
    }

    private RegionTransactionStat isRegionAlreadyInStats(List<RegionTransactionStat> regionTransactionStats, final String region) {
        return (RegionTransactionStat) CollectionUtils.find(regionTransactionStats, new Predicate() {
            @Override
            public boolean evaluate(Object regionTransactionStat) {
                return ((RegionTransactionStat) regionTransactionStat).getRegion().equalsIgnoreCase(region);
            }
        });
    }

}
