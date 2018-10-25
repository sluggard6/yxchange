package com.github.yxchange.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.github.yxchange.exception.FundNotEnoughException;
import com.github.yxchange.metadata.entity.AccountOperation;
import com.github.yxchange.metadata.entity.AccountOrder;
import com.github.yxchange.metadata.entity.Deposit;
import com.github.yxchange.metadata.mapper.DepositMapper;
import com.github.yxchange.service.AccountService;
import com.github.yxchange.service.DepositService;

public class DeposiServiceImpl implements DepositService {
	
	@Autowired
	private DepositMapper depositMapper;
	
//	@Autowired
//	private WalletService walletService;
	
	@Autowired
	private AccountService accountService;
	
	@Override
	@Cacheable
	public Deposit getDepositById(Integer depositId) {
		return depositMapper.selectByPrimaryKey(depositId);
	}
	
	@Override
	public int newDeposit(Deposit deposit) {
		if(!checkTransHash(deposit.getAccountId(), deposit.getTransHash())) {
			throw new IllegalArgumentException("transHash : '" + deposit.getTransHash() + "' is already exists");
		}
		deposit.setState(com.github.yxchange.metadata.entity.Deposit.State.NEW);
		return depositMapper.insert(deposit);
	}
	
	private boolean checkTransHash(Integer accountId, String transHash) {
		return depositMapper.countTransHash(accountId, transHash) == 0;
	}

	@Override
	@CacheEvict
	@Transactional
	public int doCharge(Integer depositId) throws FundNotEnoughException {
		Deposit deposit = getDepositById(depositId);
		AccountOrder accountOrder = new AccountOrder();
		accountOrder.setAccountId(deposit.getAccountId());
		accountOrder.setOrderId(deposit.getId().toString());
		accountOrder.setChannelId(CHANNEL_ID);
		AccountOperation accountOperation = new AccountOperation();
		accountOperation.setOrderId(accountOrder.getOrderId());
		accountOperation.setAmount(deposit.getAmount());
		accountOperation.setOperation(AccountOperation.Operation.FUND);
		List<AccountOperation> operations = new ArrayList<>();
		operations.add(accountOperation);
		accountOrder.addOperations(operations);
		accountService.addAccountOrder(accountOrder);
		deposit.setState(Deposit.State.WAIT_COLLECTION);
		return depositMapper.updateByPrimaryKey(deposit);
	}

	
}
