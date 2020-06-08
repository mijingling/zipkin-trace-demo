package org.demo;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDubboConsumerMainStart {
	private static Logger log=Logger.getLogger(SpringDubboConsumerMainStart.class);
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath*:applicationContext.xml", "classpath*:dubboConsumer.xml" });
		context.start();
		log.info("##启动ok##");
		
//		String restUrl="http://10.1.240.191:7080/restApi/user/get";
//		RestTemplate restTemplate =(RestTemplate)context.getBean("restTemplate");
//		String checkDubboResult=restTemplate.getForObject(restUrl, String.class);
//		log.info(checkDubboResult);
		System.in.read(); // 按任意键退出
	}
}
