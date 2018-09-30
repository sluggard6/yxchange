package com.github.yxchange.service;

import java.util.List;

import com.github.yxchange.exception.FundNotEnoughException;
import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.metadata.entity.AccountOrder;

public interface AccountService {

	List<Account> getAllAccount(Integer userId);

	Account getAccountByUserCoin(Integer userId, String coinName);
	
	int updateAccount(Account account);
	
	String getAddress(Account account);

	String getAddress(Integer accountId);

	Account getAccountById(Integer accountId);

	void addAccountOrder(AccountOrder accountOrder) throws FundNotEnoughException;
	
}
