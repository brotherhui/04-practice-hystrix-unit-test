package com.example.hello1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
//import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
public class BootStrapApplication {

    @Autowired
    private Hello2Service hello2Service;

    public static void main(String[] args) {
        SpringApplication.run(BootStrapApplication.class, args);
    }

    @RequestMapping(path = "/hello1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello1() {
        return "-> Hello World 1 " + hello2Service.callHello2();
    }
}
