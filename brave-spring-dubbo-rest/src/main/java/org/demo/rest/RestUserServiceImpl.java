package org.demo.rest;

import org.apache.log4j.Logger;
import org.gmall.bean.UserAddress;
import org.gmall.service.RestUserService;

public class RestUserServiceImpl implements RestUserService{
	private Logger log=Logger.getLogger(this.getClass());
	
	@Override
	public UserAddress getUserAddress() {
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId("666");
		userAddress.setUserAddress("地球-from-dubbo-rest");
		log.info("##brave-spring-dubbo-rest-provider##");
		return userAddress;
	}

}
