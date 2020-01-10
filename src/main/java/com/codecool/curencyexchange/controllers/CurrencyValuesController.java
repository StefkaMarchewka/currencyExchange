package com.codecool.curencyexchange.controllers;

import com.codecool.curencyexchange.errors.InvalidInputException;
import com.codecool.curencyexchange.models.CurrencyRates;
import com.codecool.curencyexchange.models.ExchangeRequest;
import com.codecool.curencyexchange.models.ExchangeResult;
import com.codecool.curencyexchange.repositories.ExchangeRequestRepository;
import com.codecool.curencyexchange.services.APIConsumer;
import com.codecool.curencyexchange.services.ExchangeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/exchange/values")
public class CurrencyValuesController {

    @Autowired
    private APIConsumer apiConsumer = new APIConsumer();
    @Autowired
    private ExchangeService exchangeService;
    @Autowired
    private ExchangeRequestRepository repository;
    private Logger logger = Logger.getLogger(CurrencyValuesController.class.getName());

    public CurrencyValuesController(){}

    @GetMapping()
    public List<CurrencyRates> getAvailableCurrenciesRates() {
        return apiConsumer.getCurrenciesRate();
    }

    @PostMapping()
    public ResponseEntity<ExchangeResult> exchange(@RequestBody ExchangeRequest request) throws InvalidInputException {
        repository.save(request);
        printLoggingInfo();
        return new ResponseEntity<>(exchangeService.exchange(request.getFromCurr(), request.getToCurr(), request.getAmount()), HttpStatus.CREATED);
    }


    private void printResourcesFromDb(){
        List<ExchangeRequest> savedRequest = repository.findAll();
        savedRequest.stream().forEach(request -> System.out.println(request.getRequest_id()));
    }

    private void printLoggingInfo(){
        logger.info("Request save to database");
        List<ExchangeRequest> savedRequest = repository.findAll();
        logger.info("there are " + savedRequest.size()+" records in database");
    }

}

