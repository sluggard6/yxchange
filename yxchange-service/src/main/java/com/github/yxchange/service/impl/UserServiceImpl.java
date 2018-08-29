package com.github.yxchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.yxchange.metadata.entity.User;
import com.github.yxchange.metadata.mapper.UserMapper;
import com.github.yxchange.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String username, String password) {
		return null;
	}

	@Override
	public boolean register(User user) {
		return userMapper.insertUseGeneratedKeys(user) == 1;
	}

}
