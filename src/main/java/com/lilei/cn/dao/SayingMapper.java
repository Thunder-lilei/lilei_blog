package com.lilei.cn.dao;

import com.lilei.cn.entity.Saying;
import com.lilei.cn.entity.SayingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SayingMapper {
    int countByExample(SayingExample example);

    int deleteByExample(SayingExample example);

    int insert(Saying record);

    int insertSelective(Saying record);

    List<Saying> selectByExample(SayingExample example);

    int updateByExampleSelective(@Param("record") Saying record, @Param("example") SayingExample example);

    int updateByExample(@Param("record") Saying record, @Param("example") SayingExample example);
}