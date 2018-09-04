package com.github.yxchange.metadata.mapper;

import com.github.yxchange.metadata.entity.AccountOrder;
import com.github.yxchange.metadata.entity.AccountOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AccountOrderMapper extends Mapper<AccountOrder> {
    int countByExample(AccountOrderExample example);

    int deleteByExample(AccountOrderExample example);

    List<AccountOrder> selectByExample(AccountOrderExample example);

    int updateByExampleSelective(@Param("record") AccountOrder record, @Param("example") AccountOrderExample example);

    int updateByExample(@Param("record") AccountOrder record, @Param("example") AccountOrderExample example);
}