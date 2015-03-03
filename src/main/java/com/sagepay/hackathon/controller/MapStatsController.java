package com.sagepay.hackathon.controller;

import com.sagepay.hackathon.model.RegionTransactionStat;
import com.sagepay.hackathon.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/map-stats")
@Controller
public class MapStatsController {

    @Autowired
    private StatsService statsService;

    @RequestMapping({"/", ""})
    public ModelAndView init(ModelAndView mv) {
        mv.setViewName("map-stats");

        List<RegionTransactionStat> regionTransactionStats = statsService.getAggregatedTransactionsPerRegion();
        mv.addObject("regionTransactionStats", regionTransactionStats);

        return mv;
    }

}
