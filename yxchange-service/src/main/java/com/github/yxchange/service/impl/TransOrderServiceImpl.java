package com.github.yxchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import org.apache.dubbo.config.annotation.Reference;
import com.github.yxchange.exception.OrderNotFoundException;
import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.metadata.entity.TransOrder.State;
import com.github.yxchange.metadata.mapper.TransOrderMapper;
import com.github.yxchange.service.MatchService;
import com.github.yxchange.service.TransOrderService;

@Component
public class TransOrderServiceImpl implements TransOrderService {
	
	@Autowired
	private TransOrderMapper transOrderMapper;
	
	@Reference()
	private MatchService matchService;
	
	@Override
	public TransOrder cancelOrder(Integer orderId) throws OrderNotFoundException {
		TransOrder transOrder = getTransOrderById(orderId);
		if(transOrder == null) {throw new OrderNotFoundException();}
		if(transOrder.isCanCancel()) {
			if(matchService.cancelTransOrder(transOrder)) {
				transOrder.setState(State.CANCELED);
				updateTransOrder(transOrder);
			}
		}
		return transOrder;
	}

	@Override
	@Cacheable("id")
	public TransOrder getTransOrderById(Integer orderId) {
		return transOrderMapper.selectByPrimaryKey(orderId);
	}

	@Override
	@CacheEvict("id")
	public int updateTransOrder(TransOrder transOrder) {
		return transOrderMapper.updateByPrimaryKey(transOrder);
	}

}
