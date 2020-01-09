package com.codecool.curencyexchange.controllers;

import com.codecool.curencyexchange.models.CurrencyRates;
import com.codecool.curencyexchange.services.APIConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exchange/values")
public class CurrencyValuesController {

    private APIConsumer apiConsumer = new APIConsumer();

    @GetMapping
    public List<CurrencyRates> getAvailableCurrenciesRates() {
        return apiConsumer.getCurrenciesRate();
    }
}

