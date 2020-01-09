package com.codecool.curencyexchange.services;

import com.codecool.curencyexchange.models.CurrencyRates;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class APIConsumer {

    public List getCurrenciesRate(){
        RestTemplate restTemplate = new RestTemplate();
        List<CurrencyRates> rates = new ArrayList<>();
        CurrencyRates usdRate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/eur/today/?format=json",
                CurrencyRates.class);

        CurrencyRates euroRate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/eur/today/?format=json",
                CurrencyRates.class);


        CurrencyRates uahRate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/huf/today/?format=json",
                CurrencyRates.class);

        CurrencyRates chfRate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/chf/today/?format=json",
                CurrencyRates.class);

        CurrencyRates gbpRate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/gbp/today/?format=json",
                CurrencyRates.class);

        rates.add(usdRate);
        rates.add(euroRate);
        rates.add(uahRate);
        rates.add(chfRate);
        rates.add(gbpRate);
        return rates;
    }
}
