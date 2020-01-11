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
import java.util.Optional;

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
        ExchangeResult exchangeResult = exchangeService.exchange(request.getFromCurr(), request.getToCurr(), request.getAmount());
        request.setAsk(exchangeResult.getAsk());
        request.setBid(exchangeResult.getBid());

        repository.save(request);
        printLoggingInfo(request);
        return new ResponseEntity<>(exchangeResult, HttpStatus.CREATED);
    }


    private void printResourcesFromDb(){
        List<ExchangeRequest> savedRequest = repository.findAll();
        savedRequest.stream().forEach(request -> System.out.println(request.getRequest_id()));
    }

    private void printLoggingInfo(ExchangeRequest req){
        logger.info("Request save to database");
        ExchangeRequest savedRequest = getRequestFromDb(req);

        System.out.println("Request id: " + savedRequest.getRequest_id());
        System.out.println("Requested amount: " + savedRequest.getAmount());

        System.out.println("Sold currency value: " + savedRequest.getFromCurr());
        System.out.println("Selling value: " + savedRequest.getBid());

        System.out.println("Bought currency Value: " + savedRequest.getToCurr());
        System.out.println("Buying value: " + savedRequest.getAsk());

        List<ExchangeRequest> savedRequests = repository.findAll();
        logger.info("there are " + savedRequests.size()+" records in database");
    }

    private ExchangeRequest getRequestFromDb(ExchangeRequest req) {
        long reqId = req.getRequest_id();
        Optional savedReqOptional = repository.findById(reqId);
        return (ExchangeRequest) savedReqOptional.get();
    }

}

