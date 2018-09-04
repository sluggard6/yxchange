package com.github.yxchange.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.yxchange.common.HttpResult;
import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@RequestMapping("{userId}")
	public HttpResult<List<Account>> getAllAccount(@PathVariable(required=true) Integer userId) {
		List<Account> accounts = accountService.getAllAccount(userId);
		return HttpResult.SUCCESS(accounts);
	}
}
