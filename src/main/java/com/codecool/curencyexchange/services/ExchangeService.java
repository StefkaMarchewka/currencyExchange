package com.codecool.curencyexchange.services;

import com.codecool.curencyexchange.errors.InvalidInputException;
import com.codecool.curencyexchange.models.ExchangeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeService {

    @Autowired
    private APIConsumer apiConsumer = new APIConsumer();

    public ExchangeService(){}

    public ExchangeResult exchange(String fromCurr, String toCurr, float amount) throws InvalidInputException{
        if(fromCurr.equals("pln") && !toCurr.equals("pln")){
            return buy(toCurr, amount);
        }else if (toCurr.equals("pln") && !fromCurr.equals("pln")){
            return sell(fromCurr, amount);
        }else if(toCurr.equals(fromCurr)){
            throw new InvalidInputException("Change one of the currencies");
        }else
            return handleInternationalExchange(fromCurr, toCurr, amount);
    }

    private ExchangeResult handleInternationalExchange(String fromCurr, String toCurr, float amount){
        float sellResult = sell(fromCurr, amount).getResult();
        float sellingRate = apiConsumer.getSellRate(fromCurr);
        return  buy(toCurr, sellResult, sellingRate);
    }

    private ExchangeResult buy(String currency, float amount){
        float buyingRate = apiConsumer.getBuyRate(currency);
        float result = amount / buyingRate;
        return new ExchangeResult(result, 0, buyingRate);
    }

    private ExchangeResult buy(String currency, float amount, float sellRate){
        float buyingRate = apiConsumer.getBuyRate(currency);
        float result = amount / buyingRate;
        return new ExchangeResult(result, sellRate, buyingRate);
    }


    private ExchangeResult sell(String currency, float amount){
        float sellingRate = apiConsumer.getSellRate(currency);
        float result = amount * sellingRate;
        return new ExchangeResult(result, sellingRate, 0);
    }
}
