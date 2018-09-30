package com.github.yxchange.service;

import com.github.yxchange.common.CurrencyPair;
import com.github.yxchange.metadata.entity.TransOrder;

public interface MatchService {
	
	CurrencyPair getCurrencyPair();
	
	boolean newTransOrder(TransOrder transOrder);
	
	boolean cancelTransOrder(Integer orderId, int category);

	boolean cancelTransOrder(TransOrder transOrder);
	
}
