package com.codecool.curencyexchange.controllers;

import com.codecool.curencyexchange.models.CurrencyRates;
import com.codecool.curencyexchange.models.ExchangeRequest;
import com.codecool.curencyexchange.models.ExchangeResult;
import com.codecool.curencyexchange.repositories.ExchangeRequestRepository;
import com.codecool.curencyexchange.services.APIConsumer;
import com.codecool.curencyexchange.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/exchange/values")
public class CurrencyValuesController {

    @Autowired
    private APIConsumer apiConsumer = new APIConsumer();
    @Autowired
    private ExchangeService exchangeService;

    private ExchangeRequestRepository repository;

    public CurrencyValuesController(ExchangeRequestRepository repository){
        this.repository = repository;
    }


    @GetMapping()
    public List<CurrencyRates> getAvailableCurrenciesRates() {
        return apiConsumer.getCurrenciesRate();
    }

    @PostMapping()
    public ExchangeResult exchange(@RequestBody ExchangeRequest request){
        repository.save(request);
        printResourcesFromDb();
        return exchangeService.exchange(request.getFromCurr(), request.getToCurr(), request.getAmount());
    }


    private void printResourcesFromDb(){
        List<ExchangeRequest> savedRequest = repository.findAll();
        savedRequest.stream().forEach(request -> System.out.println(request.getRequest_id()));
    }

}

