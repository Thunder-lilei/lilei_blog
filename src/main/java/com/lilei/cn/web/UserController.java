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
import com.lilei.cn.util.IfLoginutil;


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
		return mv;
	}
	/**
	 * @功能	判断登录 修改密码
	 * @参数	account为账号 newpassword为新密码
	 * @返回值 跳转login.html和message
	 */
	@RequestMapping(value="updateP",method = RequestMethod.POST)
	@ResponseBody
	private ModelAndView updateP(@RequestParam String newpassword){
		if(!IfLoginutil.IfLogin(session)) 
		{
			ModelAndView mv = new ModelAndView("redirect:/login.html");
			mv.addObject("message", "未登录！");
			return mv;
		} 
		ModelAndView mv = new ModelAndView("redirect:/login.html");
		User user = (User)session.getAttribute("user");
		user.setPassword(newpassword);
		Integer result = userservice.updatePasswordByAccountSelective(user);
		if(result.equals(1)) 
		{
			mv.addObject("message", "success");
			return mv;
		}else 
		{
			mv.addObject("message", "修改失败！");
		}
		return mv;
	}
}
