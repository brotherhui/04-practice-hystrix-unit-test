package com.example.hello1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class Hello2Service {

    @Autowired
    private Hello2Client hello2Client;
	
	@HystrixCommand(fallbackMethod = "fallbackA")
	public String callHello2(){
		return hello2Client.hello2();
	}
	
	public String fallbackA(Throwable e){
		return "hello3";
	}
}
