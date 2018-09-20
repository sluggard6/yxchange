package com.github.yxchange.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.github.yxchange.common.CurrencyPair;
import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.service.MatchService;

public class MatchServiceImpl implements MatchService, ApplicationContextAware{
	
	private CurrencyPair currencyPair;
	
	private ApplicationContext applicationContext;

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

//	@Override
//	public MatchService getInstance(CurrencyPair currencyPair) {
//		return applicationContext.getBean(currencyPair.toString(), MatchService.class);
//	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
