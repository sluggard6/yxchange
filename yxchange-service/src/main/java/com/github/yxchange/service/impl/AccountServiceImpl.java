package com.github.yxchange.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.metadata.entity.AccountExample;
import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.metadata.mapper.AccountMapper;
import com.github.yxchange.service.AccountService;
import com.github.yxchange.service.CoinService;

@Component
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private CoinService coinService;
	

	@Override
	public List<Account> getAllAccount(Integer userId) {
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria criteria = accountExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Account> accounts = accountMapper.selectByExample(accountExample);
		coinService.getAllCoin().forEach(new Consumer<Coin>() {

			@Override
			public void accept(Coin coin) {
				for(Account account : accounts) {
					if(account.getCoinId().equals(coin.getId())) {
						return;
					}
				}
				accounts.add(new Account(userId, coin.getId(), coin.getName()));
			}
		});
		return accounts;
	}


	@Override
	public Account getAccount(Integer userId, String coinName) {
		Account account = accountMapper.getAccount(userId, coinName);
		if(account == null || account.isEmpty()) {
			account = new Account();
			account.setUserId(userId);
			account.setCoinName(coinName);
			account.setCoinId(coinService.getCoinByName(coinName).getId());
			account.setAvailable(BigDecimal.ZERO);
			account.setFreezed(BigDecimal.ZERO);
			accountMapper.insertSelective(account);
		}
		System.out.println(JSON.toJSONString(account));
		return account;
	}

}
