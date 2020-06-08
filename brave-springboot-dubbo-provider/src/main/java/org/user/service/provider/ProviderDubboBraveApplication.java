package org.user.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

//开启基于注解的dubbo功能（主要是包扫描@DubboComponentScan）
//也可以在配置文件中使用dubbo.scan.base-package来替代   @EnableDubbo
@EnableDubbo
@DubboComponentScan({"brave.dubbo.rpc","org.user.service.provider.*"})
@SpringBootApplication
@ComponentScan({"brave.dubbo.rpc","org.user.service.*"})
public class ProviderDubboBraveApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderDubboBraveApplication.class, args);
	}
}
