package org.gmall.service;

import java.util.List;

import org.gmall.bean.UserAddress;

public interface OtherUserService {
	//按照用户id返回所有的收货地址
    public List<UserAddress> getUserAddressList(String userId);
}
