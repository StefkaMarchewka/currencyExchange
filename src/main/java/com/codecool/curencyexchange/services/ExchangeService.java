package com.codecool.curencyexchange.services;

import com.codecool.curencyexchange.models.ExchangeResult;
import org.springframework.stereotype.Component;

@Component
public class ExchangeService {

    private APIConsumer apiConsumer = new APIConsumer();

    public ExchangeService(){}

    public ExchangeResult exchange(String fromCurr, String toCurr, float amount){
        if(fromCurr.equals("pln")){
            return buy(toCurr, amount);
        }else if (toCurr.equals("pln")){
            return sell(fromCurr, amount);
        }
        return null;
    }

    private ExchangeResult buy(String currency, float amount){
        float buyingRate = apiConsumer.getBuyRate(currency);
        float result = amount / buyingRate;
        return new ExchangeResult(result);
    }

    private ExchangeResult sell(String currency, float amount){
        float sellingRate = apiConsumer.getSellRate(currency);
        float result = amount * sellingRate;
        return new ExchangeResult(result);
    }
}
