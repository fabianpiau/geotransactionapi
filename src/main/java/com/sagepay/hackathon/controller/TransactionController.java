package com.sagepay.hackathon.controller;

import com.sagepay.hackathon.model.RegionTransactionStat;
import com.sagepay.hackathon.model.Transaction;
import com.sagepay.hackathon.service.LocationService;
import com.sagepay.hackathon.service.StatsService;
import com.sagepay.hackathon.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/transactions")
@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private StatsService statsService;

    @RequestMapping({"/", ""})
    public ModelAndView init(ModelAndView mv) {
        mv.setViewName("transactions-filter");

        mv.addObject("locations", locationService.getAllLocations());
        mv.addObject("transactions", new ArrayList<Transaction>());

        return mv;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ModelAndView filterTransactionsByRegion(ModelAndView mv, @ModelAttribute("region") String region) {
        mv.setViewName("transactions-filter");

        mv.addObject("locations", locationService.getAllLocations());
        List<Transaction> transactions = transactionService.getTransactionsFromRegion(region);
        mv.addObject("transactions", transactions);

        return mv;
    }

    @RequestMapping(value = "/aggregate")
    public ModelAndView init(ModelAndView mv, Date begin, Date end) {
        mv.setViewName("transactions-aggregate");

        // TODO: should not be hardcoded values
        long rangeBegin = Timestamp.valueOf("2015-02-01 00:00:00").getTime();
        long rangeEnd = Timestamp.valueOf("2015-02-27 00:00:00").getTime();

        List<RegionTransactionStat> regionTransactionStats = statsService.getAggregatedTransactionsPerRegion(new Date(rangeBegin), new Date(rangeEnd));
        mv.addObject("regionTransactionStats", regionTransactionStats);

        return mv;
    }

}
