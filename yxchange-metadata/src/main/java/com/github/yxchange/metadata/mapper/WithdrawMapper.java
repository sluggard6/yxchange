package com.github.yxchange.metadata.mapper;

import com.github.yxchange.metadata.entity.Withdraw;
import com.github.yxchange.metadata.entity.WithdrawExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface WithdrawMapper extends Mapper<Withdraw> {
    int countByExample(WithdrawExample example);

    int deleteByExample(WithdrawExample example);

    List<Withdraw> selectByExample(WithdrawExample example);

    int updateByExampleSelective(@Param("record") Withdraw record, @Param("example") WithdrawExample example);

    int updateByExample(@Param("record") Withdraw record, @Param("example") WithdrawExample example);
}