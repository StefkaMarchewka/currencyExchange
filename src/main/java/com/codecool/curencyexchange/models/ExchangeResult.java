package com.codecool.curencyexchange.models;

public class ExchangeResult {
    private ExchangeRequest request;
    double result;

    public ExchangeResult(){}

    public void setRequest(ExchangeRequest request) {
        this.request = request;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public ExchangeRequest getRequest() {
        return request;
    }

    public double getResult() {
        return result;
    }
}
