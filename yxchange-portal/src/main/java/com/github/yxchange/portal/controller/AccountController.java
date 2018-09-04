package com.github.yxchange.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.yxchange.common.HttpResult;
import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.portal.exception.ResourceNotFoundException;
import com.github.yxchange.service.AccountService;
import com.github.yxchange.service.CoinService;

@RestController
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CoinService coinService;

	@RequestMapping(value="{userId}", method=RequestMethod.GET)
	public HttpResult<List<Account>> getAllAccount(@PathVariable(required=true) Integer userId) {
		List<Account> accounts = accountService.getAllAccount(userId);
		return HttpResult.SUCCESS(accounts);
	}
	
	@RequestMapping(value="{userId}/{coinName}", method=RequestMethod.GET)
	public HttpResult<Account> getAccount(@PathVariable(required=true) Integer userId, @PathVariable(required=true) String coinName) {
		if(!coinService.contains(coinName)) {
			throw new ResourceNotFoundException("coinNmae not found");
		}
		return HttpResult.SUCCESS(accountService.getAccount(userId, coinName));
	}
}
