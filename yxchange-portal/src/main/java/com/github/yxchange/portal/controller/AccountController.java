package com.github.yxchange.portal.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.yxchange.common.HttpResult;
import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.metadata.entity.User;
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

	@RequiresUser
	@GetMapping(value="{userId}")
	public HttpResult<List<Account>> getAllAccount(@PathVariable(required=true) Integer userId) {
		List<Account> accounts = accountService.getAllAccount(userId);
		return HttpResult.SUCCESS(accounts);
	}
	
	@RequiresUser
	@GetMapping(value="{userId}/{coinName}")
	public HttpResult<Account> getAccount(Integer userId, String coinName) {
		if(!coinService.contains(coinName)) {
			throw new ResourceNotFoundException("coinNmae not found");
		}
		Subject currentUser = SecurityUtils.getSubject();
		User user = (User) currentUser.getPrincipal();
		if(!user.getId().equals(userId)) {
//			throw new Auth
		}
//		currentUser
		return HttpResult.SUCCESS(accountService.getAccountByUserCoin(userId, coinName));
	}
	
	@GetMapping(value="depositAddress/{accountId}")
	public HttpResult<String> deposit(@PathVariable Integer accountId) {
		return HttpResult.SUCCESS(accountService.getAddress(accountId));
	}
}
