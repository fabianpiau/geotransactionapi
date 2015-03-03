package com.sagepay.hackathon.controller;

import com.sagepay.hackathon.model.RegionTransactionStat;
import com.sagepay.hackathon.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RequestMapping("/map-stats")
@Controller
public class MapStatsController {

    @Autowired
    private StatsService statsService;

    @RequestMapping({"/", ""})
        public ModelAndView init(ModelAndView mv, Date begin, Date end) {
        mv.setViewName("map-stats");

        long rangeBegin = Timestamp.valueOf("2015-02-01 00:00:00").getTime();
        long rangeEnd = Timestamp.valueOf("2015-02-27 00:00:00").getTime();
        // TODO: Take the date from the URL

        List<RegionTransactionStat> regionTransactionStats = statsService.getAggregatedTransactionsPerRegion(new Date(rangeBegin), new Date(rangeEnd));
        mv.addObject("regionTransactionStats", regionTransactionStats);

        return mv;
    }

}
