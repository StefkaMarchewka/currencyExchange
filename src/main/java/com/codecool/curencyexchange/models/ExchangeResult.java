package com.codecool.curencyexchange.models;


public class ExchangeResult {
    private float result;
    public ExchangeResult(){}

    public ExchangeResult(float result){
        this.result = result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public float getResult() {
        return result;
    }
}
