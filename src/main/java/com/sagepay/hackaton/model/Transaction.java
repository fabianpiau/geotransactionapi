package com.sagepay.hackaton.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    private String id;

    private Integer amount;
    private Location location;
    private Date date;

    public Transaction() {
    }

    public Transaction(Integer amount, Location location, Date date) {
        this.amount = amount;
        this.location = location;
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(
                "Transaction[id=%s, amount='%s', location='%s', date='%s']",
                id, amount, location, date);
    }
}
