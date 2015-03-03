package com.sagepay.hackathon.service;

import com.sagepay.hackathon.model.RegionTransactionStat;

import java.util.Date;
import java.util.List;

public interface StatsService {

    List<RegionTransactionStat> getAggregatedTransactionsPerRegion(Date begin, Date end);

}
