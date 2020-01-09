package com.codecool.curencyexchange.services;

import com.codecool.curencyexchange.models.ExchangeResult;
import org.springframework.stereotype.Component;

@Component
public class ExchangeService {

    public ExchangeService(){}

    public ExchangeResult exchange(){
        return new ExchangeResult();
    }
}
