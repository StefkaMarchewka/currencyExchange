package com.codecool.curencyexchange.services;

import com.codecool.curencyexchange.models.CurrencyRates;
import com.codecool.curencyexchange.models.Rate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class APIConsumer {
    private RestTemplate restTemplate = new RestTemplate();

    public List getCurrenciesRate(){

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

    public float getBuyRate(String currency){
        return getBuyRate(getRate(currency));
    }

    public float getSellRate(String currency){
        return getSellRate(getRate(currency));
    }

    private CurrencyRates getRate(String currency){
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/"+ currency.toLowerCase()+"/today/?format=json",
                CurrencyRates.class);
    }

    private float getBuyRate(CurrencyRates currencyRates){
        Rate rate = (Rate) currencyRates.getRates().get(0);
        return rate.getAsk();
    }

    private float getSellRate(CurrencyRates currencyRates){
        Rate rate = (Rate) currencyRates.getRates().get(0);
        return rate.getBid();
    }


}
