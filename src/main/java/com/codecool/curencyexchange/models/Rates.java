package com.codecool.curencyexchange.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {
    private double bid;
    private double ask;

    public Rates(){}

    public void setBid(double bid) {
        this.bid = bid;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    @Override
    public String toString() {
        return "bid=" + bid +
                "ask" + ask + '\'' +
                '}';
    }
}
