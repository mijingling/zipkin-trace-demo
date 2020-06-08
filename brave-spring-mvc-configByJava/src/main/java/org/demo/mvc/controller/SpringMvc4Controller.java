package org.demo.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpringMvc4Controller {

	//利用RestTemplate来发起Http请求
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
    public String index(){
		StringBuffer sbHtml = new StringBuffer();
        sbHtml.append("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
        .append("<title>index-list</title></head><body><div align=\"center\">")
        .append("<h1>[url-list]</h1><br/>")
        .append("<a href=/to_mvc target=\"_blank\">/to_mvc</a><br/>")
        .append("<a href=/to_dubbo target=\"_blank\">/to_dubbo</a><br/>")
        .append("</div></body></html>");
    	return sbHtml.toString();
    }

	@RequestMapping("/to_mvc")
    public String toMvc(){
		
    	return "##spring-mvc##"+restTemplate.getForObject("http://10.1.240.213:8087/for_mvc", String.class);
    }
    
    @RequestMapping(value="/to_dubbo", produces = {"application/json;charset=UTF-8"})
    public String dubbo(){
    	System.out.println("##spring-mvc4#");
    	return "##spring-mvc4#dubbo#"+restTemplate.getForObject("http://10.1.240.191:8086/dubbo", String.class);
    }
    
    @RequestMapping(value="/to_dubbo_rest", produces = {"application/json;charset=UTF-8"})
    public String dubboRest(){
    	String restUrl="http://10.1.240.191:7080/user/get";
    	return "##spring-mvc4#dubboRest#"+restTemplate.getForObject(restUrl, String.class);
    }
    
    @RequestMapping("/mvcForDubbo")
    public String forDubbo(){
    	System.out.println("##spring-mvc4##/mvcForDubbo");
    	return "hello dubbo,I am spring mvc";
    }
    
}
