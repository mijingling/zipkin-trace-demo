package org.order.service.consumer.controller;

import java.util.List;

import org.gmall.bean.UserAddress;
import org.gmall.service.OtherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
public class OrderController {

	@Reference
	OtherUserService otherUserService;

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String index() {
		StringBuffer sbHtml = new StringBuffer();
		sbHtml.append("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
				.append("<title>url-list</title></head><body><div align=\"center\">")
				.append("<h1>[index-list]</h1><br/>")
				.append("<a href=/dubbo target=\"_blank\">/dubbo</a><br/>")
				.append("</div></body></html>");
		return sbHtml.toString();
	}

	// 通过spring-mvc对外提供的api服务
	@RequestMapping("/dubbo")
	public List<UserAddress> dubbo() {
		// 调用brave-provider
		return otherUserService.getUserAddressList("2-brave");
	}
	// 通过spring-mvc对外提供的api服务
	@RequestMapping("/dubboRest")
	public String dubboRest() {
		String restUrl="http://10.1.240.191:7080/user/get";
    	return "##dubboRest##"+restTemplate.getForObject(restUrl, String.class);
	}

}
