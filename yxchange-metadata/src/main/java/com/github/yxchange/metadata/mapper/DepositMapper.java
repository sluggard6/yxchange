package com.github.yxchange.metadata.mapper;

import com.github.yxchange.metadata.entity.Deposit;
import com.github.yxchange.metadata.entity.DepositExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface DepositMapper extends Mapper<Deposit> {
    int countByExample(DepositExample example);

    int deleteByExample(DepositExample example);

    List<Deposit> selectByExample(DepositExample example);

    int updateByExampleSelective(@Param("record") Deposit record, @Param("example") DepositExample example);

    int updateByExample(@Param("record") Deposit record, @Param("example") DepositExample example);

	default int countTransHash(Integer accountId, String transHash) {

		DepositExample depositExample = new DepositExample();
		DepositExample.Criteria criteria = depositExample.createCriteria();
		criteria.andAccountIdEqualTo(accountId).andTransHashEqualTo(transHash);
		return countByExample(depositExample);
	}
    
    
}