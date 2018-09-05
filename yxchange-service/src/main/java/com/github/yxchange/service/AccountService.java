package com.github.yxchange.service;

import java.util.List;

import com.github.yxchange.metadata.entity.Account;

public interface AccountService {

	List<Account> getAllAccount(Integer userId);

	Account getAccount(Integer userId, String coinName);
	
	int updateAccount(Account account);
	
	String getAddress(Account account);
	
}
