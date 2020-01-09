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
            return sell(toCurr, amount);
        }
        return null;
    }

    private ExchangeResult buy(String currency, float amount){
        return new ExchangeResult(apiConsumer.getBuyRate(currency));
    }

    private ExchangeResult sell(String currency, float amount){
        return new ExchangeResult(0);
    }
}
