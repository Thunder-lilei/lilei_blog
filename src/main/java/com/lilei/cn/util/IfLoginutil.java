package com.lilei.cn.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.lilei.cn.entity.User;


public class IfLoginutil {
	public static Boolean IfLogin(HttpSession session) 
	{
		User record = new User();
		record = (User) session.getAttribute("user");
		if(record!=null) 
		{
			return true;
		}else 
		{
			return false;
		}
	}
}
