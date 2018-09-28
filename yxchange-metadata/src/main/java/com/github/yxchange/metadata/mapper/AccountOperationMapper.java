package com.github.yxchange.metadata.mapper;

import java.math.BigDecimal;

import com.github.yxchange.metadata.entity.AccountOperation;

import tk.mybatis.mapper.common.Mapper;

public interface AccountOperationMapper extends Mapper<AccountOperation> {
	
	BigDecimal getUnFreezed(String freezeOrderId);

}