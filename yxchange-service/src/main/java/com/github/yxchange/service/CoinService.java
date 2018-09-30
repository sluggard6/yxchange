package com.github.yxchange.service;

import java.util.List;

import com.github.yxchange.common.CurrencyPair;
import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.metadata.entity.Trade;
import com.github.yxchange.metadata.entity.TransOrder;

public interface CoinService {
	
	List<Coin> getAllCoin();
	
	int addCoin(Coin coin);
	
	boolean contains(String coinName);
	
	Coin getCoin(Integer id);
	
	Coin getCoinByName(String coinName);
	
	CurrencyPair getCurrencyPair(String name);

	CurrencyPair getCurrencyPair(TransOrder transOrder);
	
	CurrencyPair getCurrencyPair(Trade trade);

}
