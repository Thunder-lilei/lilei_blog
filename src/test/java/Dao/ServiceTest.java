package Dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lilei.cn.entity.User;
import com.lilei.cn.service.UserService;

public class ServiceTest extends BaseTest{
	@Autowired
	UserService userservice;
	
	@Test
	public void updateP() 
	{
		User user = userservice.selectByA("lilei.kuge@qq.com");
		if(user != null) 
		{
			user.setPassword("lilei");
			Integer result = userservice.updatePasswordByAccountSelective(user);
			if(result.equals(1)) 
			{
				System.out.println("yes");
			}else 
			{
				System.out.println("修改失败！");
			}
		}else 
		{ 
			System.out.println("错误的账号！");
		}
	}
}
