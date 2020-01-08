package com.codecool.curencyexchange.models;

import com.codecool.curencyexchange.helpers.MySerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    @JsonProperty("sell")
    @JsonSerialize(using = MySerializer.class)
   // @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    private double bid;

    @JsonSerialize(using = MySerializer.class)
    @JsonProperty("buy")
    //@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    private double ask;
    private Date effectiveDate;

    public Rate(){}

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

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
