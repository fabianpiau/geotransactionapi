package com.sagepay.hackathon.controller;

import com.sagepay.hackathon.model.RegionTransactionStat;
import com.sagepay.hackathon.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@Controller
public class RestApiController {

    @Autowired
    private StatsService statsService;

    @RequestMapping(value = "/aggregate")
    public @ResponseBody
    List<RegionTransactionStat> aggregate(Date begin, Date end) {

        long rangeBegin = Timestamp.valueOf("2015-02-01 00:00:00").getTime();
        long rangeEnd = Timestamp.valueOf("2015-02-27 00:00:00").getTime();
        // TODO: Take the date from the URL

        return  statsService.getAggregatedTransactionsPerRegion(new Date(rangeBegin), new Date(rangeEnd));
    }

}
