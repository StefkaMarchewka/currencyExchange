package com.codecool.curencyexchange.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {
    private float bid;
    private float ask;
    private Date effectiveDate;

    public Rate(){}

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public float getBid() {
        return bid;
    }

    public float getAsk() {
        return ask;
    }

    @Override
    public String toString() {
        return "bid=" + bid +
                "ask" + ask + '\'' +
                '}';
    }



}
