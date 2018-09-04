package com.github.yxchange.service.impl;

import com.github.yxchange.metadata.entity.User;
import com.github.yxchange.metadata.entity.UserExample;
import com.github.yxchange.metadata.mapper.UserMapper;
import com.github.yxchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		user.setSalt(newSalt());
		user.setPassword(getMaskPassword(user.getPassword(), user.getSalt()));
		return userMapper.insertSelective(user) > 0;
	}

	@Override
	public User search(String userName) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(userName);
		return userMapper.selectOneByExample(userExample);

	}

}
