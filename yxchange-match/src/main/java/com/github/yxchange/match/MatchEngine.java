package com.github.yxchange.match;

import com.github.yxchange.common.CurrencyPair;
import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.service.MatchService;

public enum MatchEngine implements MatchService {
	;

	@Override
	public CurrencyPair getCurrencyPair() {
		return null;
	}

	@Override
	public void newTransOrder(TransOrder transOrder) {
		
	}

	@Override
	public void cancelTransOrder(Integer orderId, int category) {
		
	}
}
