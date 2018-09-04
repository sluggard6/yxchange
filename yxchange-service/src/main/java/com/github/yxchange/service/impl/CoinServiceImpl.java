package com.github.yxchange.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.metadata.mapper.CoinMapper;
import com.github.yxchange.service.CoinService;

@Component
public class CoinServiceImpl implements CoinService {
	
	private List<Coin> coinTemplate = new ArrayList<>();
	
	@Autowired
	private CoinMapper coinMapper;
	
	private void init() {
		synchronized (coinTemplate) {
			coinTemplate.clear();
			coinTemplate.addAll(coinMapper.selectAll());
		}
	}

	@Override
	public List<Coin> getAllCoin() {
		if(coinTemplate.isEmpty()) {init();}
		return Collections.unmodifiableList(coinTemplate);
	}

	@Override
	public int addCoin(Coin coin) {
		int i =coinMapper.insert(coin);
		init();
		return i;
	}

}
