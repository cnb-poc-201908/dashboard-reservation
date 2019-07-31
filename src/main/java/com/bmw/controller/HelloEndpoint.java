package com.bmw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.EurekaInstanceConfig;

@RestController
public class HelloEndpoint {
	private static Logger logger = LoggerFactory.getLogger(HelloEndpoint.class);
    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;
    @Value("${server.port}")
    private int serverPort = 0;

    @GetMapping("/hello")
    public String hello() {
    	logger.info("/hello, instanceId:{}, host:{}" , eurekaInstanceConfig.getInstanceId() , eurekaInstanceConfig.getHostName(false));
        return "Hello, Spring Cloud! My port is " + serverPort;
    }
}
