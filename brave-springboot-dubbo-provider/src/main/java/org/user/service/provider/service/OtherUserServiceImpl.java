package org.user.service.provider.service;

import java.util.ArrayList;
import java.util.List;

import org.gmall.bean.UserAddress;
import org.gmall.service.OtherUserService;

import com.alibaba.dubbo.config.annotation.Service;

@Service // 属于Dubbo的@Service注解，非Spring 作用：暴露服务
public class OtherUserServiceImpl implements OtherUserService {

	//利用RestTemplate来发起Http请求
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("#OtherUserService#consumer#userId" + userId);
		List<UserAddress> userAddressList = new ArrayList<>();
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(userId);
		userAddress.setUserAddress("地球");
		userAddressList.add(userAddress);
		
//        restTemplate.getForObject("http://10.1.240.191:8088/mvcForDubbo", String.class);
        
		return userAddressList;
	}

}
