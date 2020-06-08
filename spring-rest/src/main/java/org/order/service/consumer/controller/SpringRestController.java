package org.order.service.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpringRestController {

	//利用RestTemplate来发起Http请求
	final RestTemplate restTemplate;

	//另一种注入方式：构造注入restTemplate至Spring容器
    @Autowired
    SpringRestController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @RequestMapping("/rest")
    public String rest(){
    	System.out.println("##spring-rest##/rest");
    	return "##spring-rest##"+restTemplate.getForObject("http://10.1.240.191:8081/dubbo", String.class);
    }
}
