package com.codecool.curencyexchange.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExchangeRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long request_id;
    private String fromCurr;
    private String toCurr;
    private float amount;
    private float bid;
    private float ask;

    public ExchangeRequest(){}

    public ExchangeRequest(String from, String to, float amount){
        this.amount = amount;
        this.fromCurr = from;
        this.toCurr = to;
    }

    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public void setFromCurr(String fromCurr) {
        this.fromCurr = fromCurr;
    }

    public void setToCurr(String toCurr) {
        this.toCurr = toCurr;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getFromCurr() {
        return fromCurr;
    }

    public String getToCurr() {
        return toCurr;
    }

    public float getAmount() {
        return amount;
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

    public void setBid(float bid) {
        this.bid = bid;
    }


}
