package org.order.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({ "brave.dubbo.rpc", "org.order.service.consumer" }) // 增加"brave.dubbo.rpc"的扫描；如果之前默认扫描范围，在使用该注解后，需要补加启动类所属包名
public class BraveSpringBootMvcRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BraveSpringBootMvcRestApplication.class, args);
	}
	
	@Bean
	RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
}