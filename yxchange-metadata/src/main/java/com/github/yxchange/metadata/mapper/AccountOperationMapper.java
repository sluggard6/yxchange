package com.github.yxchange.metadata.mapper;

import com.github.yxchange.metadata.entity.AccountOperation;
import com.github.yxchange.metadata.entity.AccountOperationExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AccountOperationMapper extends Mapper<AccountOperation> {
    int countByExample(AccountOperationExample example);

    int deleteByExample(AccountOperationExample example);

    List<AccountOperation> selectByExample(AccountOperationExample example);

    int updateByExampleSelective(@Param("record") AccountOperation record, @Param("example") AccountOperationExample example);

    int updateByExample(@Param("record") AccountOperation record, @Param("example") AccountOperationExample example);

	BigDecimal getUnFreezed(String freezeOrderId);
}