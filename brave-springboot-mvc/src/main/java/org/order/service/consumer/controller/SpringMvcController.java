package org.order.service.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpringMvcController {
	
	@Autowired
	private RestTemplate restTemplate; //该实例，来自工具包中RestTemplate注册到容器中的@Bean
	
	@RequestMapping("/")
    public String index(){
		StringBuffer sbHtml = new StringBuffer();
        sbHtml.append("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
        .append("<title>【Zipkin-Demo-V0.6】</title></head><body><div style=\"margin-left:30px\">")
        .append("<h1>~~~ [访问组合Demo] ~~~</h1>")
        .append("<a href=\"http://10.1.240.213:8086/dubbo\" target=\"_blank\">[1] dubboConmuser->dubboProvider</a><br/>")
        .append("<a href=\"http://10.1.240.213:8087/mvc\" target=\"_blank\">[2] mvc->dubboConmuser->dubboProvider</a><br/>")
        .append("<h1>~~~ [链路查询Zipkin] ~~~</h1>")
        .append("<a href=\"http://10.1.240.213:9412\" target=\"_blank\">zipkin-server</a>（目前使用es存储）<br/><br/>")
        
        .append("<span style=\"color:red;\">PS：官网支持es存储有局限(不支持Dependencies查看，但不影响Trace查看)，需要通过依赖包执行依赖关系索引生成，目前配置了自动执行，也支持手动触发 </span><br/>")
        .append("<span>每5mins自动生成当日依赖索引</span><br/>")
        .append("<a href=\"http://10.1.240.213:9402/runjob/today\" target=\"_blank\">主动触发【今日】依赖索引生成</a><br/>")
        .append("<a href=\"http://10.1.240.213:9402/runjob/yesterday\" target=\"_blank\">主动触发【昨日】依赖索引生成</a><br/>")
        
        .append("<h1>~~~ [排查工具-ES查询] ~~~</h1>")
        .append("<a href=\"http://10.1.240.213:9100/?auth_user=esadmin&auth_password=123456&base_uri=http://10.1.240.213:9201\" target=\"_blank\">es-head</a>(数据浏览tab页可以看存储数据详情)<br/>")
        .append("<h1>~~~ [排查工具-dubbo监控] ~~~</h1>")
        .append("<a href=\"http://10.1.240.213:9414/#/service?filter=%2a&pattern=service\" target=\"_blank\">dubbo-admin</a><br/>")
        .append("</div></body></html>");
    	return sbHtml.toString();
    }
	
    @RequestMapping("/mvc")
    public String rest(){
    	return "##spring-mvc##"+restTemplate.getForObject("http://10.1.240.213:8086/dubbo", String.class);
    }
    
    @RequestMapping("/mvcForDubbo")
    public String forDubbo(){
    	System.out.println("##spring-mvc##/mvcForDubbo");
    	return "hello dubbo,I am spring mvc";
    }
    @RequestMapping("/for_mvc")
    public String forMvc(){
    	System.out.println("##spring-mvc##/for_mvc");
    	return "hello mvc,I am from spring mvc";
    }
    
    
}
