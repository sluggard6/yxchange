package com.github.yxchange.service.impl;

import com.github.yxchange.common.CurrencyPair;
import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.service.MatchService;

public class MatchServiceImpl implements MatchService{
	
	private CurrencyPair currencyPair;
	
//	private 

	@Override
	public CurrencyPair getCurrencyPair() {
		return currencyPair;
	}

	@Override
	public void newTransOrder(TransOrder transOrder) {
		
	}

	@Override
	public void cancelTransOrder(Integer orderId, int category) {
		
	}

	@Override
	public MatchService getInstance(CurrencyPair currencyPair) {
		return null;
	}

}
