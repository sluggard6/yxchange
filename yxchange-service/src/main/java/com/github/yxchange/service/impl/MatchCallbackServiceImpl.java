package com.github.yxchange.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.github.yxchange.metadata.entity.Trade;
import com.github.yxchange.service.MatchCallbackService;

@Service(timeout = 5000)
public class MatchCallbackServiceImpl implements MatchCallbackService {

	@Override
	public void TradeCallBack(Trade trade) {
		
	}

}
