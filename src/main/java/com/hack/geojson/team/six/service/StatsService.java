package com.hack.geojson.team.six.service;

import com.hack.geojson.team.six.model.RegionTransactionStat;

import java.util.Date;
import java.util.List;

public interface StatsService {

    List<RegionTransactionStat> getAggregatedTransactionsPerRegion(Date begin, Date end);

}
