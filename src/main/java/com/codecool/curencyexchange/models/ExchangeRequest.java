package com.codecool.curencyexchange.models;

public class ExchangeRequest {
    String from;
    String to;
    float amount;

    public ExchangeRequest(){}

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public float getAmount() {
        return amount;
    }


}
