package com.github.yxchange.metadata.mapper;

import com.github.yxchange.metadata.entity.Trade;
import com.github.yxchange.metadata.entity.TradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TradeMapper extends Mapper<Trade> {
    int countByExample(TradeExample example);

    int deleteByExample(TradeExample example);

    List<Trade> selectByExample(TradeExample example);

    int updateByExampleSelective(@Param("record") Trade record, @Param("example") TradeExample example);

    int updateByExample(@Param("record") Trade record, @Param("example") TradeExample example);
}