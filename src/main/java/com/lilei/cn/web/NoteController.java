package com.lilei.cn.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lilei.cn.entity.Note;
import com.lilei.cn.entity.User;
import com.lilei.cn.service.NoteService;

/**
 * @author lilei
 *
 * 2020年9月26日
 */
@Controller
@RequestMapping("/note")
public class NoteController extends BaseController{
	@Autowired
	private NoteService noteservice;
	
	
	/**
	 * @功能	从前端获取page
	 * @参数	html
	 * @返回值
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="getpage",method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> getpage(@RequestParam String title,@RequestParam String introduction,@RequestParam String page,@RequestParam String imagesrc){
		Map<String,Object> modelMap=new HashMap<>();
		User user = (User) session.getAttribute("user");
		if(user!=null) 
		{
			Note note = new Note();
			if(note != null) 
			{
				note.setTitle(title);
				note.setIntroduction(introduction);
				note.setContent(page);
				note.setTime(new Date());
				note.setImage(imagesrc);
				note.setAuthor(user.getName());
				System.out.println(note);
				noteservice.insertSelective(note);
				System.out.println("文章创建成功！");
				modelMap.put("message", "success");
				return modelMap;
			}else 
			{ 
				modelMap.put("message", "文章创建失败！");
			}  
		}else
		{
			modelMap.put("message", "nosigin");
		}
		
		return modelMap;
	}
	/**
	 * @功能	向前端传递所有page
	 * @参数
	 * @返回值
	 */
	@RequestMapping(value="putpage",method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> putpage(@RequestParam String id){
		Map<String,Object> modelMap=new HashMap<>();
		Note page = new Note();
		page = noteservice.selectByPrimaryKey(Integer.parseInt(id));
			if(page != null) 
			{
				System.out.println("查询成功！");
				modelMap.put("message", "success");
				modelMap.put("page", page);
				return modelMap;
			}else 
			{ 
				modelMap.put("message", "查询失败！");
			}  
		return modelMap;
	}
	/**
	 * @功能 按id查询page
	 * @参数 id
	 * @返回值 note对象
	 */
	@RequestMapping(value="putpages",method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> putpages(){
		Map<String,Object> modelMap=new HashMap<>();
		List<Note> list = new ArrayList<Note>();
		list = noteservice.selectAll();
			if(list != null) 
			{
				System.out.println("查询全部成功！");
				modelMap.put("message", "success");
				modelMap.put("list", list);
				return modelMap;
			}else 
			{ 
				modelMap.put("message", "还没有博客！");
			}  
		return modelMap;
	}
	/**
	 * @功能 查询所有note的title author time
	 * @参数 无参数
	 * @返回值 list
	 */
	@RequestMapping(value="gettimeline",method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> gettimeline(){
		Map<String,Object> modelMap=new HashMap<>();
		List<Note> list  = noteservice.selecttimelineAll();
		if(list != null) 
		{
			modelMap.put("message", "success");
			modelMap.put("list", list);
			return modelMap;
		}else 
		{ 
			modelMap.put("message", "还没有博客！");
		}  
		return modelMap;
	}
//	/**
//	 * @功能	获取文章信息 获取作者信息 保存文章
//	 * @参数	五个参数均为文章属性
//	 * @返回值
//	 */
//	@SuppressWarnings("unused")
//	@RequestMapping(value="create",method = RequestMethod.POST)
//	@ResponseBody
//	private ModelAndView Login(@RequestParam String title,@RequestParam String introduction,
//						@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date time,@RequestParam String content){
//		ModelAndView mv = new ModelAndView("redirect:/index.html");
//		Note note = new Note();
//		note.setAll(title, content, introduction, time);
//		if(note != null) 
//		{
//			User user = (User) session.getAttribute("user");
//			note.setAuthor(user.getName());
//			System.out.println(note);
//			noteservice.insertSelective(note);
//			System.out.println("文章创建成功！");
//			mv.addObject("message", "文章创建成功！");
//			return mv;
//		}else 
//		{ 
//			mv.addObject("message", "文章创建失败！");
//		}
//		try {
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			mv.addObject("success",false);
//			mv.addObject("errMsg",e.toString());
//		}
//		return mv;
//	}
//	/**
//	 * @功能	传递文章信息
//	 * @参数	id文章noteid
//	 * @返回值
//	 */
//	@RequestMapping(value="getnote",method = RequestMethod.GET)
//	@ResponseBody
//	private Map<String,Object> getnote(@RequestParam String id){
//		Map<String,Object> modelMap=new HashMap<>();
//		Note note = new Note();
//		note = noteservice.selectByPrimaryKey(Integer.parseInt(id));
//		if(note != null) 
//		{
//			System.out.println("文章获取成功！");
//			modelMap.put("message", "success");
//			modelMap.put("note", note);
//			return modelMap;
//		}else 
//		{ 
//			modelMap.put("message", "文章获取失败！");
//		}
//		try {
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			modelMap.put("success",false);
//			modelMap.put("errMsg",e.toString());
//		}
//		return modelMap;
//	}
}
