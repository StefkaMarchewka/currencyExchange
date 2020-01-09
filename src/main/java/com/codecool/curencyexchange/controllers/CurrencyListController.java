package com.codecool.curencyexchange.controllers;

import com.codecool.curencyexchange.models.CurrencyRates;
import com.codecool.curencyexchange.services.APIConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exchange/currencies")
public class CurrencyListController {
    private APIConsumer apiConsumer = new APIConsumer();


    @GetMapping
    public List<CurrencyRates> getAvailableCurrenciesRates(){
        return apiConsumer.getCurrenciesRate();
    }








}
