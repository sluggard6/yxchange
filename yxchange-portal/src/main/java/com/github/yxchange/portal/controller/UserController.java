package com.github.yxchange.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.yxchange.common.HttpResult;
import com.github.yxchange.metadata.entity.User;
import com.github.yxchange.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public User login(String username, String password) {
		return userService.login(username, password);
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public User register(User user) {
		user.setId(null);
		if(userService.register(user)) {
			return user;
		} else {
			return null;
		}
	}
	@RequestMapping(value="search", method=RequestMethod.GET)
	public HttpResult<User> search(String userName) {
		User user = userService.search(userName);
		return HttpResult.SUCCESS(user);
	}

}
