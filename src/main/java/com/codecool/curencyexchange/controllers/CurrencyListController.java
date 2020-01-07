package com.codecool.curencyexchange.controllers;

import com.codecool.curencyexchange.models.CurrencyRates;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exchange/currencies")
public class CurrencyListController {

    @GetMapping
    public List<CurrencyRates> getAvailableCurrenciesRates(RestTemplate restTemplate){
        List<CurrencyRates> rates = new ArrayList<>();
        CurrencyRates rate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/chf/", CurrencyRates.class);
        rates.add(rate);
        return rates;

    }







}
