package com.github.yxchange.service;

import com.github.yxchange.metadata.entity.User;

public interface UserService {
	
	User login(String username, String password);
	
	boolean register(User user);

}
