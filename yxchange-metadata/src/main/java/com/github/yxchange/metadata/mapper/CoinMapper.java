package com.github.yxchange.metadata.mapper;

import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.metadata.entity.CoinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CoinMapper extends Mapper<Coin> {
    int countByExample(CoinExample example);

    int deleteByExample(CoinExample example);

    List<Coin> selectByExample(CoinExample example);

    int updateByExampleSelective(@Param("record") Coin record, @Param("example") CoinExample example);

    int updateByExample(@Param("record") Coin record, @Param("example") CoinExample example);
}