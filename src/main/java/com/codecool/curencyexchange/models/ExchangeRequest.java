package com.codecool.curencyexchange.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExchangeRequest {
    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long request_id;
    String fromCurr;
    String toCurr;
    float amount;

    public ExchangeRequest(){}

    public ExchangeRequest(String from, String to, float amount){
        this.amount = amount;
        this.fromCurr = from;
        this.toCurr = to;
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


}
