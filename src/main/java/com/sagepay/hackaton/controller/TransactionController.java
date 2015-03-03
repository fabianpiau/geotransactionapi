package com.sagepay.hackaton.controller;

import com.sagepay.hackaton.model.Transaction;
import com.sagepay.hackaton.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping("/transactions")
    public String index(Map<String, Object> model) {
        List<Transaction> transactions = transactionRepository.findByLocationRegion("West Midlands");
        model.put("transactions", transactions);
        return "transactions";
    }
}
