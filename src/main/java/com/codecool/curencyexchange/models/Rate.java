package com.codecool.curencyexchange.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    //@JsonProperty("sell")
    private float bid;
    //@JsonProperty("buy")
    private float ask;
    //@JsonProperty("date")
    private LocalDate effectiveDate;

    public Rate(){}


//    @Override
//    public String toString() {
//        return "bid=" + sell +
//                "ask" + buy + '\'' +
//                '}';
//    }


    public void setBid(float bid) {
        this.bid = bid;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public float getBid() {
        return bid;
    }

    public float getAsk() {
        return ask;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }
}
