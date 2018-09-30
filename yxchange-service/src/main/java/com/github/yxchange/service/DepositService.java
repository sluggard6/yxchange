package com.github.yxchange.service;

import com.github.yxchange.exception.FundNotEnoughException;
import com.github.yxchange.metadata.entity.Deposit;

public interface DepositService {
	
	int CHANNEL_ID = 1;
	
	Deposit getDepositById(Integer depositId);
	
	int newDeposit(Deposit deposit);
	
	int doCharge(Integer depositId) throws FundNotEnoughException;

}
