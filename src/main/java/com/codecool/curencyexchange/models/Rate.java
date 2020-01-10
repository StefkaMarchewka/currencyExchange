package com.codecool.curencyexchange.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    private float bid;
    private float ask;
    private LocalDate effectiveDate;

    public Rate(){}

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
