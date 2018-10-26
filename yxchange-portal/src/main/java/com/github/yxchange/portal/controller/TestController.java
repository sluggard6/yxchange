package com.github.yxchange.portal.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.yxchange.common.HttpResult;
import com.github.yxchange.exception.FundNotEnoughException;
import com.github.yxchange.metadata.entity.Account;
import com.github.yxchange.metadata.entity.AccountOperation;
import com.github.yxchange.metadata.entity.AccountOperation.Operation;
import com.github.yxchange.metadata.entity.AccountOrder;
import com.github.yxchange.metadata.entity.Deposit;
import com.github.yxchange.service.AccountService;

@RestController("test")
public class TestController {
	
	private static final int CHANNEL_ID = 99;
	
	@Autowired
	private AccountService accountService;

    @RequestMapping(value="exception", method=RequestMethod.GET)
    public Object exception(){
        throw new RuntimeException("test exception");
    }
    
    @RequestMapping(value="testCharge", method=RequestMethod.POST)
    public HttpResult<Deposit> testCharge(String coinName, BigDecimal amount, Integer userId) throws FundNotEnoughException {
    	AccountOrder accountOrder = new AccountOrder();
    	accountOrder.setOrderId("test-"+System.currentTimeMillis());
    	accountOrder.setChannelId(CHANNEL_ID);
    	Account account = accountService.getAccountByUserCoin(userId, coinName);
    	accountOrder.setAccountId(account.getId());
    	AccountOperation accountOperation = new AccountOperation();
    	accountOperation.setAmount(amount);
    	accountOperation.setOrderId(accountOrder.getOrderId());
    	accountOperation.setOperation(Operation.FUND);
    	accountOrder.addOperation(accountOperation);
    	accountService.addAccountOrder(accountOrder);
    	return HttpResult.SUCCESS();
    }
    
}
