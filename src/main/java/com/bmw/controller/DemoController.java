package com.bmw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	RestTemplate restTemplate;

    @GetMapping("/authdemo")
    public String getDemoAuthResource(){
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
        	String result = restTemplate.getForObject("https://stage.apigw.cdkapps.cn/service/MBOBI/987501/ping", String.class);
			logger.info("result:{}", result);
		} catch (RestClientException e) {
			logger.error("Failed to ping", e);
		}

    	return "";
    }
}