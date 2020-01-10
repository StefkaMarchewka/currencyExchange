package com.codecool.curencyexchange.services;

import com.codecool.curencyexchange.errors.InvalidInputException;
import com.codecool.curencyexchange.models.Currency;
import com.codecool.curencyexchange.models.CurrencyRates;
import com.codecool.curencyexchange.models.Rate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class APIConsumer {
    private RestTemplate restTemplate = new RestTemplate();
    private final String[] codes = {"eur", "usd", "huf", "chf", "gbp"};

    public List getCurrenciesRate(){
        List<CurrencyRates> rates = new ArrayList<>();

        for (String code: codes) {
            CurrencyRates currencyRates = getRate(code);
            rates.add(currencyRates);
        }
        return rates;
    }

    public List getCurrenciesList(){
        List<Currency> availableCurr = new ArrayList<>();
        for (String code: codes) {
            Currency currency = getCurrency(getCurrency(code));
            availableCurr.add(currency);
        }
        return availableCurr;
    }


    public float getBuyRate(String currency) throws InvalidInputException{
        return getBuyRate(getRate(currency));
    }

    public float getSellRate(String currency)throws InvalidInputException{
        return getSellRate(getRate(currency));
    }


    private Optional<CurrencyRates> getRate(String currency){
        return Optional.ofNullable(restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/"+ currency.toLowerCase()+"/today/?format=json",
                CurrencyRates.class));
    }

    private float getBuyRate(Optional<CurrencyRates> optional) throws InvalidInputException{
        Rate rate = null;
        if(optional.isPresent()){
            rate = (Rate) optional.get().getRates().get(0);
        }else throw new InvalidInputException("invalid currency code");
        return rate.getAsk();
    }

    private float getSellRate(Optional<CurrencyRates> optional) throws InvalidInputException{
        Rate rate = null;
        if(optional.isPresent()){
            rate = (Rate) optional.get().getRates().get(0);
        }else throw new InvalidInputException("invalid currency code");
        //Rate rate = (Rate) currencyRates.getRates().get(0);
        return rate.getBid();
    }

    //this is the same method as getRate
    private CurrencyRates getCurrencyRate(String currencyCode){
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/" + currencyCode +"/today/?format=json",
                CurrencyRates.class);
    }

    private CurrencyRates getCurrency(String code){
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/c/"+ code.toLowerCase()+"/today/?format=json",
                CurrencyRates.class);
    }

    private Currency getCurrency(CurrencyRates currencyRates){
        String currencyName = currencyRates.getCurrency();
        String currencyCode = currencyRates.getCode();
        return new Currency(currencyName, currencyCode);
    }
}
