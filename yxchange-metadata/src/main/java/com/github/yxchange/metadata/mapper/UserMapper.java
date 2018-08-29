package com.github.yxchange.metadata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.yxchange.metadata.entity.User;
import com.github.yxchange.metadata.entity.UserExample;
import com.github.yxchange.metadata.provider.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}