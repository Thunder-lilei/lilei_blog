package com.lilei.cn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lilei.cn.entity.User;
import com.lilei.cn.entity.UserExample;

public interface UserService {
    List<User> selectAll();

    User selectByPrimaryKey(String name);
    
    User selectByAandP(User record);
    
    User selectByA(String account);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    
    int updatePasswordByAccountSelective(User record);
}
