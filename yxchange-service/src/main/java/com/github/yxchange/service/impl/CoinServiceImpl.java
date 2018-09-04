package com.github.yxchange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.metadata.entity.CoinExample;
import com.github.yxchange.metadata.mapper.CoinMapper;
import com.github.yxchange.service.CoinService;

@Component
public class CoinServiceImpl implements CoinService {

	@Autowired
	private CoinMapper coinMapper;
	
	@Override
	@Cacheable("allCoin")
	public List<Coin> getAllCoin() {
		return coinMapper.selectAll();
	}

	@Override
	@CacheEvict("allCoin")
	public int addCoin(Coin coin) {
		return coinMapper.insert(coin);
	}

	@Override
	public boolean contains(String coinName) {
		return getCoinByName(coinName) != null;
	}

	@Override
	@Cacheable("coin")
	public Coin getCoinByName(String coinName) {
		CoinExample coinExample = new CoinExample();
		CoinExample.Criteria criteria = coinExample.createCriteria();
		criteria.andNameEqualTo(coinName);
		return coinMapper.selectOneByExample(coinExample);
	}
	
//	private Map<String, Coin> coinMap = new LinkedHashMap<>();
//	
//	private List<String> coinNameTemplate = new ArrayList<>();
//	
//	@Autowired
//	private CoinMapper coinMapper;
//	
//	private void init() {
//		synchronized (coinMap) {
//			coinMap.clear();
//			coinNameTemplate.clear();
//			coinMapper.selectAll().forEach(coin -> {
//				System.out.println(coin);
//				coinMap.put(coin.getName(), coin);
//				coinNameTemplate.add(coin.getName());
//			});
//		}
//	}
//
//	@Override
//	@Cacheable
//	public List<Coin> getAllCoin() {
//		if(coinMap.isEmpty()) {init();}
//		List<Coin> coins = new ArrayList<>();
//		coins.addAll(coinMap.values());
//		return coins;
//	}
//
//	@Override
//	public int addCoin(Coin coin) {
//		int i = coinMapper.insert(coin);
//		init();
//		return i;
//	}
//
//	@Override
//	public boolean contains(String coinName) {
//		return coinNameTemplate.contains(coinName);
//	}
//	
//
//	@Override
//	public Coin getCoinByName(String coinName) {
//		return coinMap.get(coinName);
//	}

}
