package com.codecool.curencyexchange.controllers;

import com.codecool.curencyexchange.models.CurrencyRates;
import com.codecool.curencyexchange.services.APIConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/exchange/currencies")
public class CurrencyListController{

    @Autowired
    private APIConsumer apiConsumer = new APIConsumer();

    public CurrencyListController(){}

    @GetMapping()
    public List<CurrencyRates> getAvailableCurrencies() {
        return apiConsumer.getCurrenciesList();
    }


}
