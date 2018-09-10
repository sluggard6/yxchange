package com.github.yxchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.yxchange.metadata.entity.Deposit;
import com.github.yxchange.metadata.mapper.DepositMapper;
import com.github.yxchange.service.DepositService;

public class DeposiServiceImpl implements DepositService {
	

	@Autowired
	private DepositMapper depositMapper;
	
	@Override
	public int newDeposit(Deposit deposit) {
//		depositMapper.countByExample(example)
		return 0;
	}

}
