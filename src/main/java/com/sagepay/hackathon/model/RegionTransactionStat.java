package com.sagepay.hackathon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class RegionTransactionStat {

    private String region;
    private Integer totalAmount;
    private Integer nbTransactions;

    public RegionTransactionStat(String region, Integer totalAmount, Integer nbTransactions) {
        this.region = region;
        this.totalAmount = totalAmount;
        this.nbTransactions = nbTransactions;
    }

    public RegionTransactionStat(String region) {
        this.region = region;
    }

    public RegionTransactionStat() {

    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @JsonIgnore
    public Integer getTotalAmountAsInteger() {
        return totalAmount;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal(totalAmount / 100.00);
        return amount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getNbTransactions() {
        return nbTransactions;
    }

    public void setNbTransactions(Integer nbTransactions) {
        this.nbTransactions = nbTransactions;
    }

    @Override
    public String toString() {
        return String.format(
                "RegionTransactionStat[region='%s', totalAmount='%s', nbTransactions='%s']",
                region, totalAmount, nbTransactions);
    }
}
