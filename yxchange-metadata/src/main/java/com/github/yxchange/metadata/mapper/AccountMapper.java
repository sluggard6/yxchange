package com.github.yxchange.metadata.mapper;

import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.metadata.entity.AccountExample;

import tk.mybatis.mapper.common.Mapper;

public interface AccountMapper extends Mapper<Account> {
	
	default Account getAccount(Integer userId, String coinName) {
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria criteria = accountExample.createCriteria();
		criteria.andUserIdEqualTo(userId).andCoinNameEqualTo(coinName);
		return selectOneByExample(accountExample);
	}
}