package com.github.yxchange.service;

import java.util.UUID;

import com.github.yxchange.metadata.entity.User;
import com.github.yxchange.util.MD5Util;

public interface UserService {
	
	User login(String username, String password);
	
	boolean register(User user);

	User search(String userName);
	
	default String newSalt() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	default String getMaskPassword(String password, String salt) {
		return MD5Util.getMD5Str(password+salt);
	}
}
