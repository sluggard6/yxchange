package com.github.yxchange.service;

import java.util.UUID;

import com.github.yxchange.metadata.entity.User;
import com.github.yxchange.util.MD5Util;

public interface UserService {
	
	User login(String username, String password);
	
	boolean register(User user);

	User getUserByName(String userName);
	
	User getUserById(Integer userId);
	
	int updateUser(User user);
	
	default String newSalt() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	default String getMaskPassword(String password, String salt) {
		return MD5Util.getMD5Str(password+salt);
	}
}
