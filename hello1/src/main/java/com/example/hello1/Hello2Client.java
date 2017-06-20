package com.example.hello1;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "hello2",
url = "http://localhost:9091")
public interface Hello2Client {

    @RequestMapping(method = RequestMethod.GET, value = "/hello2", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String hello2();

}
