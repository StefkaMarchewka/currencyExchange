package com.codecool.curencyexchange.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRates {
    private String currency;
    private String code;
    private List<Rate> rates;

    public CurrencyRates(){}


    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List getRates() {
        return rates;
    }

    public void addRate(Rate rate){
        rates.add(rate);
    }
}
