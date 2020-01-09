package com.codecool.curencyexchange.services;

import com.codecool.curencyexchange.models.ExchangeResult;
import org.springframework.stereotype.Component;

@Component
public class ExchangeService {

    private APIConsumer apiConsumer;

    public ExchangeService(){}

    public ExchangeResult exchange(String fromCurr, String toCurr, float amount){
        if(fromCurr.equals("pln")){
            buy(toCurr, amount);
        }else if (toCurr.equals("pln")){
            sell(toCurr, amount);
        }else{
            //exchange into pl and then buy
        }

        return new ExchangeResult(0);
    }

    private ExchangeResult buy(String currency, float amount){
        return new ExchangeResult(apiConsumer.getBuyRate(currency));
    }

    private float sell(String currency, float amount){
        return 0;
    }
}
