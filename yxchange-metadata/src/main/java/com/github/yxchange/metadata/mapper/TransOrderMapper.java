package com.github.yxchange.metadata.mapper;

import com.github.yxchange.metadata.entity.TransOrder;
import com.github.yxchange.metadata.entity.TransOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TransOrderMapper extends Mapper<TransOrder> {
    int countByExample(TransOrderExample example);

    int deleteByExample(TransOrderExample example);

    List<TransOrder> selectByExample(TransOrderExample example);

    int updateByExampleSelective(@Param("record") TransOrder record, @Param("example") TransOrderExample example);

    int updateByExample(@Param("record") TransOrder record, @Param("example") TransOrderExample example);
}