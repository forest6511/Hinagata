# Hinagata

Currently this project is self-study about Spring Boot.

## Development

### Up Docker for development environment
1. Change directory to ./docker
2. Issue the command
```
docker-compose up
```

|Middleware Name|Ports|User/Pass|Description|
|---|---|---|---|
|MySQL 5.7|3306|root/pass|-|
|Redis|6379|NA|-|
|ElasticSearch 5.2|9200|NA|-|
|Kibana 5.2|5601|NA|-| 
|LogStash 5.2|5044|NA|Output application log for now.|


### Run Spring Development 
```    
mvn spring-boot:run -Drun.profiles=dev
```

### Unite Testing (Server)
```    
mvn test
```

### Kibana

http://localhost:5601/

Show all index
```    
GET _cat/indices?v
```

Create index of 'logstash-*' by default on Kibana.
You can confirm index like 'logstash-YYYY.MM.DD'.

ex)
```
{"@timestamp":"2017-03-30T05:28:09.795+09:00","@version":1,
"message":"Adding return parameter of type Ljp/hinagata/model/rest/SessionSample;"
,"logger_name":"springfox.documentation.spring.web.readers.operation.OperationModelsProvider"
,"thread_name":"main","level":"DEBUG","level_value":10000,"HOSTNAME":"XXXX-XXXX.local"}
```

## TODO or rather I would like to do
1. Implement Spring-Security and Admin console screens( '/admin/**' is administrator or operator uri). Mainly server side is Restful API.
2. Currently application log goes to elasticsearch via logstash but not only log but also application data.
3. Implement React JS on front-side and Karma testing tool.
4. Would like to create generator of java entities or front-side js by what (Yoeman?). like Rails. I would like to generate apis such as OAuth by less coding.  This is the goal.


### Reference
- Spring Boot
https://projects.spring.io/spring-boot/
- Swagger
http://swagger.io/
- ElasticSearch
https://www.elastic.co/guide/index.html
- Logback JSON encoder
https://github.com/logstash/logstash-logback-encoder/tree/logstash-logback-encoder-4.9