package com.github.yxchange.service;

import java.util.List;

import com.github.yxchange.metadata.entity.Coin;

public interface CoinService {
	
	List<Coin> getAllCoin();
	
	int addCoin(Coin coin);
	
	boolean contains(String coinName);
	
	Coin getCoinByName(String coinName);

}
