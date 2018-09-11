package com.github.yxchange.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.github.yxchange.exception.FundNotEnoughException;
import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.metadata.entity.AccountExample;
import com.github.yxchange.metadata.entity.AccountOperation;
import com.github.yxchange.metadata.entity.AccountOrder;
import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.metadata.mapper.AccountMapper;
import com.github.yxchange.metadata.mapper.AccountOperationMapper;
import com.github.yxchange.metadata.mapper.AccountOrderMapper;
import com.github.yxchange.service.AccountService;
import com.github.yxchange.service.CoinService;
import com.github.yxchange.service.WalletService;

@Component
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private CoinService coinService;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private AccountOrderMapper accountOrderMapper;
	
	@Autowired
	private AccountOperationMapper accountOperationMapper;
	

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
	public Account getAccountByUserCoin(Integer userId, String coinName) {
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
		return account;
	}


	@Override
	public int updateAccount(Account account) {
		return accountMapper.updateByPrimaryKey(account);
	}


	@Override
	public String getAddress(Account account) {
		if(StringUtils.isEmpty(account.getAddress())) {
			String address = walletService.getDepositAddress(account.getCoinName());
			account.setAddress(address);
			updateAccount(account);
		}
		return account.getAddress();
	}
	
	@Override
	public String getAddress(Integer accountId) {
		return getAddress(getAccountById(accountId));
	}

	@Override
	public Account getAccountById(Integer accountId) {
		return accountMapper.selectByPrimaryKey(accountId);
	}


	@Override
	public void addAccountOrder(AccountOrder accountOrder) {
		Account account = getAccountById(accountOrder.getAccountId());
		accountOrder.setAvailableBefore(account.getAvailable());
		accountOrder.setFreezedBefore(account.getFreezed());
		for(AccountOperation accountOperation : accountOrder.getOperations()) {
			doOperation(accountOperation, account);
		}
		accountOrder.setAvailableAfter(account.getAvailable());
		accountOrder.setFreezedAfter(account.getFreezed());
		accountOrderMapper.insert(accountOrder);
		accountMapper.updateByPrimaryKey(account);
	}


	private void doOperation(AccountOperation accountOperation, Account account) {
		checkUnFreezed(accountOperation);
		accountOperation.setAvailableBefore(account.getAvailable());
		accountOperation.setFreezedBefore(account.getFreezed());
		if(accountOperation.getOperationEnum().equals(AccountOperation.Operation.FUND)) {
			if(!account.addAvailable(accountOperation.getAmount())) {
				throw new FundNotEnoughException();
			}
		}else {
			if(!account.addFreezed(accountOperation.getAmount())) {
				throw new FundNotEnoughException();
			}
		}
		accountOperation.setAvailableAfter(account.getAvailable());
		accountOperation.setFreezedAfter(account.getFreezed());
		accountOperationMapper.insert(accountOperation);
	}


	private void checkUnFreezed(AccountOperation accountOperation) {
		if(accountOperation.isUnFreezed()) {
			BigDecimal result = accountOperationMapper.getUnFreezed(accountOperation.getFreezeOrderId());
			if(result.add(accountOperation.getAmount()).compareTo(BigDecimal.ZERO) < 0) {
				throw new FundNotEnoughException("can't unFreezed, unFreezed:" + result + ",amount:" + accountOperation.getAmount());
			}
		}
	}

}
