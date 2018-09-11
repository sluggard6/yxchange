package com.github.yxchange.metadata.mapper;

import java.math.BigDecimal;

import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.metadata.entity.AccountExample;

import tk.mybatis.mapper.common.Mapper;

public interface AccountMapper extends Mapper<Account> {
	
	/**
	 * 根据用户id和币种获取用户账户
	 * @param userId
	 * @param coinName
	 * @return
	 */
	default Account getAccount(Integer userId, String coinName) {
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria criteria = accountExample.createCriteria();
		criteria.andUserIdEqualTo(userId).andCoinNameEqualTo(coinName);
		return selectOneByExample(accountExample);
	}

	/**
	 * 更新用户账户，乐观锁检查期间资金是否被更改
	 * @param account
	 * @param availableBefore
	 * @param freezedBefore
	 * @return 修改的行数，正常为1
	 */
	default int updateByPrimaryKeyOnCompare(Account account, BigDecimal availableBefore, BigDecimal freezedBefore) {
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria criteria = accountExample.createCriteria();
		criteria.andIdEqualTo(account.getId())
			.andAvailableEqualTo(availableBefore)
			.andFreezedEqualTo(freezedBefore);
		return updateByExampleSelective(account, accountExample);
	}
	
}