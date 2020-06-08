package org.order.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo
@DubboComponentScan({"brave.dubbo.rpc","org.order.service.consumer*"})
@SpringBootApplication
@ComponentScan({"brave.dubbo.rpc","org.order.service.consumer*"})
public class ConsumerDubboBraveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDubboBraveApplication.class, args);
    }
    @Bean
    RestTemplate restTemplate() {
    	return new RestTemplate();
    }
    
}