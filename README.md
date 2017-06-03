# Hinagata
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f393ebc0d000419097dcb9bc3af6d8d7)](https://www.codacy.com/app/forest6511/Hinagata?utm_source=github.com&utm_medium=referral&utm_content=forest6511/Hinagata&utm_campaign=badger)
[![Build Status](https://travis-ci.org/forest6511/Hinagata.svg?branch=master)](https://travis-ci.org/forest6511/Hinagata.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/forest6511/Hinagata/badge.svg?branch=master)](https://coveralls.io/github/forest6511/Hinagata?branch=master) 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f393ebc0d000419097dcb9bc3af6d8d7)](https://www.codacy.com/app/forest6511/Hinagata?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=forest6511/Hinagata&amp;utm_campaign=Badge_Grade)  
Currently this project is self-study about Spring Boot.

## Development

### Up Docker for development environment
1. Change directory to ./docker
2. Issue the command
```
docker-compose up
```

|Middleware|Ports|User/Pass|Description|
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
mvn clean test
```

### Kibana

http://localhost:5601/

confirm index,mapping
```    
GET _cat/indices?v
GET /logstash-*
GET /_mapping
GET /logstash-*/_mapping

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
2. Currently application log goes to elasticsearch via logstash. Not only log but also application data.
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