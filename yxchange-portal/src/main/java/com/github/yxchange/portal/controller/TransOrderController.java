package com.github.yxchange.portal.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.yxchange.common.HttpResult;
import com.github.yxchange.exception.FundNotEnoughException;
import com.github.yxchange.exception.OrderNotFoundException;
import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.metadata.entity.TransOrder.Category;
import com.github.yxchange.portal.exception.ResourceNotFoundException;
import com.github.yxchange.service.AccountService;
import com.github.yxchange.service.TransOrderService;

@RestController
@RequestMapping("order")
public class TransOrderController {
	
	@Autowired
	private TransOrderService transOrderService;
	
	@Autowired
	private AccountService accountService;
	
//	@RequestMapping(value="takeOrder", method=RequestMethod.POST)
//	public HttpResult<TransOrder> takeOrder(@RequestBody TransOrder transOrder) throws FundNotEnoughException {
//		transOrderService.takeOrder(transOrder);
//		return HttpResult.SUCCESS();
//	}
	
	@RequestMapping(value="takeOrder", method=RequestMethod.POST)
	public HttpResult<TransOrder> takeOrder(Integer accountId, Integer baseId, Integer counterId, int category, BigDecimal price, BigDecimal amount) throws FundNotEnoughException {
		int userId = 1;
		int coinId;
		if(Category.ASK.ordinal() == category) {
			coinId = baseId;
		}else if(Category.BID.ordinal() == category) {
			coinId = counterId;
		}else {
			throw new IllegalArgumentException();
		}
		Account account = accountService.getAccountByUserCoin(userId, coinId);
		if(account.getId() != accountId) {
			throw new ResourceNotFoundException();
		}
		TransOrder transOrder = new TransOrder();
		transOrder.setAccountId(accountId);
		transOrder.setBaseId(baseId);
		transOrder.setCounterId(counterId);
		transOrder.setCategory(category);
		transOrder.setAmount(amount);
		transOrder.setPrice(price);
		transOrderService.takeOrder(transOrder);
		return HttpResult.SUCCESS();
	}
	
	@RequestMapping(value="cancelOrder", method=RequestMethod.POST)
	public HttpResult<TransOrder> cancalOrder(Integer orderId) {
		try {
			TransOrder transOrder = transOrderService.cancelOrder(orderId);
			return HttpResult.SUCCESS(transOrder);
		} catch (OrderNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("order not found", e);
		}
	}
	
	

}
