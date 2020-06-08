package org.demo.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	/**
	 *   必须注册RestTemplate作为一个bean，以便拦截器被注入
	 */
	@Bean
	RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
