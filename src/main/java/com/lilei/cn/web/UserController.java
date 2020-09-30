package com.lilei.cn.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lilei.cn.entity.User;
import com.lilei.cn.service.UserService;


/**
 * @author lilei
 *
 * 2020年9月26日
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userservice;
	
	/**
	 * @功能	账号密码登陆 保存用户信息
	 * @参数	account为账号 password为密码
	 * @返回值
	 */
	@RequestMapping(value="Login",method = RequestMethod.POST)
	@ResponseBody
	private ModelAndView Login(@RequestParam String account,@RequestParam String password){
		ModelAndView mv = new ModelAndView("redirect:/index.html");
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user = userservice.selectByAandP(user);
		if(user != null) 
		{
			session.setAttribute("user", user);
			System.out.println(user.getName()+"登陆成功！");
			mv.addObject("message", "success");
			return mv;
		}else 
		{ 
			mv.addObject("message", "错误的账号或密码！");
		}
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("success",false);
			mv.addObject("errMsg",e.toString());
		}
		return mv;
	}
}
