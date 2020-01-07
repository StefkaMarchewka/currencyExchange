package com.codecool.curencyexchange.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
public class CurrencyRates {
    private String currency;
    private String code;
    private Rates rates;

    public CurrencyRates(){}


    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public Rates getRates() {
        return rates;
    }
}
