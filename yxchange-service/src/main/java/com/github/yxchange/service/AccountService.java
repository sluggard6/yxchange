package com.github.yxchange.service;

import java.util.List;

import com.github.yxchange.metadata.entity.Account;

public interface AccountService {

	List<Account> getAllAccount(Integer userId);

	Account getAccountByUserCoin(Integer userId, String coinName);
	
	int updateAccount(Account account);
	
	String getAddress(Account account);

	String getAddress(Integer accountId);

	Account getAccountById(Integer accountId);
	
}
