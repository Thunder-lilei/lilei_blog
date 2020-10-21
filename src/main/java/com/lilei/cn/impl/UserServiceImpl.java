package com.lilei.cn.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lilei.cn.dao.UserMapper;
import com.lilei.cn.entity.User;
import com.lilei.cn.entity.UserExample;
import com.lilei.cn.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper usermapper;

	@Override
	public User selectByPrimaryKey(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectByAandP(User record) {
		// TODO Auto-generated method stub
		return usermapper.selectByAandP(record);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return usermapper.selectAll();
	}

	@Override
	public User selectByA(String account) {
		// TODO Auto-generated method stub
		return usermapper.selectByA(account);
	}

	@Override
	public int updatePasswordByAccountSelective(User record) {
		// TODO Auto-generated method stub
		return usermapper.updatePasswordByAccountSelective(record);
	}

}
