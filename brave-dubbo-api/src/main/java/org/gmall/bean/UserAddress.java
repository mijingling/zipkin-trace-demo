package org.gmall.bean;

import java.io.Serializable;

public class UserAddress implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private String userAddress; //用户地址
    private String userId; //用户id
    
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
    
}
