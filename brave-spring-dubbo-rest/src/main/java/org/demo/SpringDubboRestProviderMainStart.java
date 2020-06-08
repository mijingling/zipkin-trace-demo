package org.demo;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDubboRestProviderMainStart {
	private static Logger log=Logger.getLogger(SpringDubboRestProviderMainStart.class);
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath*:applicationContext.xml", "classpath*:dubboProvider.xml" });
		context.start();
		log.info("##启动ok##");
		System.in.read(); // 按任意键退出
	}
}
