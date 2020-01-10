package com.codecool.curencyexchange.services;

import com.codecool.curencyexchange.models.ExchangeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeService {

    @Autowired
    private APIConsumer apiConsumer = new APIConsumer();

    public ExchangeService(){}

    //todo error handling if both currencies are the same
    public ExchangeResult exchange(String fromCurr, String toCurr, float amount){
        if(fromCurr.equals("pln") && !toCurr.equals("pln")){
            return buy(toCurr, amount);
        }else if (toCurr.equals("pln") && !fromCurr.equals("pln")){
            return sell(fromCurr, amount);
        }else
            return handleInternationalExchange(fromCurr, toCurr, amount);
    }

    private ExchangeResult handleInternationalExchange(String fromCurr, String toCurr, float amount){
        float sellResult = sell(fromCurr, amount).getResult();
        return  buy(toCurr, sellResult);
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
