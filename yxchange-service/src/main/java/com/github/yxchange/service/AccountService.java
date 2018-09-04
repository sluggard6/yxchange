package com.github.yxchange.service;

import java.util.List;

import com.github.yxchange.metadata.entity.Account;

public interface AccountService {

	List<Account> getAllAccount(Integer userId);

}
