package com.github.yxchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.dubbo.common.Constants;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import com.github.yxchange.common.CurrencyPair;
import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.service.CoinService;
import com.github.yxchange.service.MatchService;

public class MatchServiceImpl implements MatchService{
	
	private CurrencyPair currencyPair;
	
	
	@Reference
	private MatchService provider;
	
	@Autowired
	private CoinService coinService;
	
	@Override
	public CurrencyPair getCurrencyPair() {
		return currencyPair;
	}

	@Override
	public boolean newTransOrder(TransOrder transOrder) {
		RpcContext.getContext().setAttachment(Constants.REQUEST_TAG_KEY, coinService.getCurrencyPair(transOrder).toString());
		return provider.newTransOrder(transOrder);
	}

	@Override
	public boolean cancelTransOrder(TransOrder transOrder) {
		RpcContext.getContext().setAttachment(Constants.REQUEST_TAG_KEY, coinService.getCurrencyPair(transOrder).toString());
		return provider.cancelTransOrder(transOrder);
	}

	@Override
	public boolean cancelTransOrder(Integer orderId, int category) {
		throw new UnsupportedOperationException("proxy implements unsupport this method");
	}
	
//	private CurrencyPair buildCurr

}
