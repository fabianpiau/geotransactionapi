package com.sagepay.hackathon.controller;

import com.sagepay.hackathon.model.Transaction;
import com.sagepay.hackathon.service.LocationService;
import com.sagepay.hackathon.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/map")
@Controller
public class MapController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private LocationService locationService;

    @RequestMapping({"/", ""})
    public ModelAndView init(ModelAndView mv) {
        mv.setViewName("map");

        mv.addObject("locations", locationService.getAllLocations());
        mv.addObject("transactions", new ArrayList<Transaction>());

        return mv;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ModelAndView filterTransactionsByRegion(ModelAndView mv, @ModelAttribute("region") String region) {
        mv.setViewName("map");

        mv.addObject("locations", locationService.getAllLocations());
        List<Transaction> transactions = transactionService.getTransactionsFromRegion(region);
        mv.addObject("transactions", transactions);

        return mv;
    }

}
