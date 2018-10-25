package com.github.yxchange.service;

import com.github.yxchange.exception.FundNotEnoughException;
import com.github.yxchange.exception.OrderNotFoundException;
import com.github.yxchange.metadata.entity.TransOrder;

public interface TransOrderService {
	
	TransOrder getTransOrderById(Integer orderId);
	
	int updateTransOrder(TransOrder transOrder);
	
	void takeOrder(TransOrder transOrder) throws FundNotEnoughException;

	TransOrder cancelOrder(Integer orderId) throws OrderNotFoundException;

}
