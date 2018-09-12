package com.github.yxchange.service;

import com.github.yxchange.common.CurrencyPair;
import com.github.yxchange.metadata.entity.TransOrder;

public interface MatchService {
	
	CurrencyPair getCurrencyPair();
	
	void setCurrencyPair(CurrencyPair currencyPair);
	
	void newTransOrder(TransOrder transOrder);
	
	void cancelTransOrder(Integer orderId, int category);

}
