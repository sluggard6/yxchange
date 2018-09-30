package com.github.yxchange.service;

import com.github.yxchange.common.CurrencyPair;

public interface MatchManagerService {
	
	MatchService getMatchService(CurrencyPair currencyPari);

}
