package com.sagepay.hackathon.controller;

import com.sagepay.hackathon.model.Transaction;
import com.sagepay.hackathon.service.LocationService;
import com.sagepay.hackathon.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private LocationService locationService;

    @RequestMapping("/maps")
    public ModelAndView transactions(ModelAndView mv) {
        mv.setViewName("maps");

        mv.addObject("locations", locationService.getAllLocations());
        List<Transaction> transactions = transactionService.getTransactionsFromRegion("West Midlands");
        mv.addObject("transactions", transactions);

        return mv;
    }
}
