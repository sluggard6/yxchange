package com.github.yxchange.metadata.mapper;

import com.github.yxchange.metadata.entity.AccountAddress;
import com.github.yxchange.metadata.entity.AccountAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AccountAddressMapper extends Mapper<AccountAddress> {
    int countByExample(AccountAddressExample example);

    int deleteByExample(AccountAddressExample example);

    List<AccountAddress> selectByExample(AccountAddressExample example);

    int updateByExampleSelective(@Param("record") AccountAddress record, @Param("example") AccountAddressExample example);

    int updateByExample(@Param("record") AccountAddress record, @Param("example") AccountAddressExample example);
}