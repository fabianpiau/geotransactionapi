package com.sagepay.hackaton.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Transaction {
    @Id
    private String id;

    private Integer amount;
    private Location location;

    public Transaction() {}

    public Transaction(Integer amount, Location location) {
        this.amount = amount;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format(
                "Transaction[id=%s, amount='%s', location='%s']",
                id, amount, location);
    }
}
