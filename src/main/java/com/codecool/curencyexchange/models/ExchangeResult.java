package com.codecool.curencyexchange.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ExchangeResult {
    private float result;

    @JsonCreator
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
