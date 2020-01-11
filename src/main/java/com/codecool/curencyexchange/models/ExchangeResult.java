package com.codecool.curencyexchange.models;


public class ExchangeResult {
    private float result;
    private float bid;
    private float ask;

    public ExchangeResult(){}

    public ExchangeResult(float result, float bid, float ask){
        this.result = result;
        this.ask = ask;
        this.bid = bid;
    }

    public float getBid() {return bid;}

    public float getAsk() { return ask;}

    public void setBid(float bid) {this.bid = bid; }

    public void setAsk(float ask) {this.ask = ask; }

    public void setResult(float result) {
        this.result = result;
    }

    public float getResult() {
        return result;
    }
}
