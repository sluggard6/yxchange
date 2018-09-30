package com.github.yxchange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.github.yxchange.common.CurrencyPair;
import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.metadata.entity.CoinExample;
import com.github.yxchange.metadata.entity.Trade;
import com.github.yxchange.metadata.entity.TransOrder;
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
	@Cacheable("name")
	public Coin getCoinByName(String coinName) {
		CoinExample coinExample = new CoinExample();
		CoinExample.Criteria criteria = coinExample.createCriteria();
		criteria.andNameEqualTo(coinName);
		return coinMapper.selectOneByExample(coinExample);
	}

	@Override
	public CurrencyPair getCurrencyPair(String currencyPair) {
	    int split = currencyPair.indexOf('/');
	    if (split < 1) {
	      throw new IllegalArgumentException(
	          "Could not parse currency pair from '" + currencyPair + "'");
	    }
	    String baseName = currencyPair.substring(0, split);
	    String counterName = currencyPair.substring(split + 1);
	    Coin base = getCoinByName(baseName);
	    Coin counter = getCoinByName(counterName);
		return new CurrencyPair(base, counter);
	}
	
	@Override
	public CurrencyPair getCurrencyPair(TransOrder transOrder) {
		return new CurrencyPair(getCoin(transOrder.getBaseId()), getCoin(transOrder.getCounterId()));
	}

	@Override
	public CurrencyPair getCurrencyPair(Trade trade) {
//		return new CurrencyPair(trade.get, counter);
		throw new UnsupportedOperationException("还没来得及实现");
	}
	
	@Override
	@Cacheable("id")
	public Coin getCoin(Integer id) {
		return coinMapper.selectByPrimaryKey(id);
	}

}
