package com.codecool.curencyexchange.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ExchangeResult {
    //private ExchangeRequest request;
    private float result;

    @JsonCreator
    public ExchangeResult(){}

    public ExchangeResult(float result){
        this.result = result;
    }

    //public void setRequest(ExchangeRequest request) {
//        this.request = request;
//    }

    public void setResult(float result) {
        this.result = result;
    }

//    public ExchangeRequest getRequest() {
//        return request;
//    }

    public float getResult() {
        return result;
    }
}
