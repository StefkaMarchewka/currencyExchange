package com.codecool.curencyexchange.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    private String currName;
    private String currCode;

    public Currency(){}

    public Currency(String currName, String currCode){
        this.currCode = currCode;
        this.currName = currName;
    }

    public void setCurrName(String currName) {
        this.currName = currName;
    }

    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }

    public String getCurrName() {
        return currName;
    }

    public String getCurrCode() {
        return currCode;
    }
}
