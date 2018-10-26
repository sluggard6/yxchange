package com.github.yxchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.yxchange.exception.FundNotEnoughException;
import com.github.yxchange.exception.OrderNotFoundException;
import com.github.yxchange.metadata.entity.AccountOperation;
import com.github.yxchange.metadata.entity.AccountOperation.Operation;
import com.github.yxchange.metadata.entity.AccountOrder;
import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.metadata.entity.TransOrder.State;
import com.github.yxchange.metadata.mapper.TransOrderMapper;
import com.github.yxchange.service.AccountService;
import com.github.yxchange.service.MatchService;
import com.github.yxchange.service.TransOrderService;

@Component
public class TransOrderServiceImpl implements TransOrderService {
	
	private static final int CHANNEL_ID = 2;
	
	@Autowired
	private TransOrderMapper transOrderMapper;
	
	@Autowired
	private AccountService accountService;
	
//	@Reference()
	private MatchService matchService;
	
	@Override
	public TransOrder cancelOrder(Integer orderId) throws OrderNotFoundException {
		TransOrder transOrder = getTransOrderById(orderId);
		if(transOrder == null) {throw new OrderNotFoundException();}
		if(transOrder.isCanCancel()) {
			if(matchService.cancelTransOrder(transOrder)) {
				transOrder.setState(State.CANCELED);
				updateTransOrder(transOrder);
			}
		}
		return transOrder;
	}

	@Override
	@Cacheable("id")
	public TransOrder getTransOrderById(Integer orderId) {
		return transOrderMapper.selectByPrimaryKey(orderId);
	}

	@Override
	@CacheEvict("id")
	public int updateTransOrder(TransOrder transOrder) {
		return transOrderMapper.updateByPrimaryKey(transOrder);
	}

	@Override
	@Transactional
	public void takeOrder(TransOrder transOrder) throws FundNotEnoughException {
		transOrderMapper.insert(transOrder);
		AccountOrder accountOrder = new AccountOrder();
		accountOrder.setAccountId(transOrder.getAccountId());
		accountOrder.setOrderId(transOrder.getId().toString());
		accountOrder.setChannelId(CHANNEL_ID);
		AccountOperation accountOperation = new AccountOperation();
		accountOperation.setOrderId(accountOrder.getOrderId());
		accountOperation.setAmount(transOrder.getAmount().multiply(transOrder.getPrice()));
		accountOperation.setOperation(Operation.FREEZE);
		accountOrder.addOperation(accountOperation);
		accountService.addAccountOrder(accountOrder);
//		matchService.newTransOrder(transOrder);
	}

}
