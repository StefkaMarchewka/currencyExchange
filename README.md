Currency exchange application in form of REST API. Allows to count exchange value of chosen currencies according to
actual exchange rates published by NBP for 5 currencies. 

Application allows to see list of supported currencies with GET request on following endpoint:
http://localhost:8080/exchange/currencies
Application allows to see list of supported currencies and their actual values with GET request on following endpoint:
http://localhost:8080/exchange/values
Application allows to count value of exchanged currencies with POST request on following endpoint:
http://localhost:8080/exchange/values
    
    POST request accept data in form on JSON file. Valid JSON file format:
    {"fromCurr":"pln",
      "toCurr":"chf",
      "amount":20
      }
    
    Parameters: "fromCurr" is code of currency which we want to exchagne, "toCurr" it code of currency we want to buy, 
    "amout" refers to currency we want to exchage ("fromCurr"). 
    
    Application returns response in form of JSON file in following format:
    {
    "result": 5.0510154,
    "bid": 0.0,
    "ask": 3.9596
      }
      
     Parameters: "result" is exchanged value of currency chosen as "toCurr" parameter, "bid" is sells rate of currency 
     chosen as "fromCurr" (if "fromCurr" is polish zloty bid value is 0.0), "ask" is buying value of currency chosen 
     as toCurr (if "toCurr" is polish zloty ask value is 0.0).
     
Application written in SpringBoot, use NBP API to obtain actual exchage rates. Save every exchage request to 
H2 database with following information: codes of exchanged currencies with theirs rates, amount of exchanged currency.
API documentation has been generated with Swagger.

Start applicatin with command:
$ docker-compose up
 
