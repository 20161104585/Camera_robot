package com.imnu.mm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.imnu.mm.pojo.User;
import com.imnu.mm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	//普通用户登录
	@RequestMapping(value = "/login",produces = "text/html;charset=utf-8")
	public ModelAndView login(User user) {
		User u = userService.login(user);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			mv.setViewName("message/index");
			mv.addObject("user", u);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
//	//超级管理员登录
//	@RequestMapping(value = "/loginadmin",produces = "text/html;charset=utf-8")
//	public ModelAndView loginAdmin(Supadmin supadmin) {
//		Supadmin sup = userService.loginAdmin(supadmin);
//		ModelAndView mv = new ModelAndView();
//		if(sup!=null) {
//			List<User> user = userService.selectUser();
//			mv.addObject("user", user);
//			mv.setViewName("admin");
//			return mv;
//		}else {
//			mv.setViewName("redirect:/loginadmin.jsp");
//			return mv;
//		}
//
//	}

	//用户注册
	@RequestMapping(value = "/register",produces = "text/html;charset=utf-8")
	public ModelAndView register(User user) {
		userService.register(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/login.jsp");
		return mv;
	}
//	/**
//	 * ajax三级联动
//	 * @return
//	 * 	一级联动
//	 */
//    @RequestMapping(value="/findAllProvince",produces = "text/html;charset=utf-8")
//	@ResponseBody
//	public String province(){
//    	List<ThinkAreas> provinceList = userService.findAllProvince();//省份
//    	System.out.println("province加载完毕");
//    	for (ThinkAreas thinkArueas : provinceList) {
//			System.out.println(thinkArueas);
//		}
//		return JSON.toJSONString(provinceList);
//	
//	}
//    //二级联动
//    @RequestMapping(value="/findAllCityByProvincename",produces = "text/html;charset=utf-8")
//	@ResponseBody
//	public String city(String provincename){
//    	List<ThinkAreas> cityList = userService.findAllCityByProvincename(provincename);//省份
//    	System.out.println("city加载完毕");
//    	for (ThinkAreas thinkArueas : cityList) {
//			System.out.println(thinkArueas);
//		}
//		return JSON.toJSONString(cityList);
//	
//	}
//    //三级联动
//    @RequestMapping(value="/findAllCountyBycityname",produces = "text/html;charset=utf-8")
//	@ResponseBody
//	public String county(String cityname){
//    	List<ThinkAreas> countyList = userService.findAllCountyBycityname(cityname);//省份
//    	System.out.println("county加载完毕");
//    	for (ThinkAreas thinkArueas : countyList) {
//			System.out.println(thinkArueas);
//		}
//		return JSON.toJSONString(countyList);
//	
//	}
    //校验用户名是否存在
    @RequestMapping(value="/checkUsername",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String checkUname(String username){
    	int rs;
    	Boolean result = userService.checkUsername(username);//省份
    	if(result==true) {
    		rs=1;//用户名不存在
    	}else {
    		rs=0;//用户名存在
    	}
		return JSON.toJSONString(rs);
	
	}
    
    @RequestMapping(value="/deleteUser",produces = "text/html;charset=utf-8")
	public ModelAndView deleteUser(Integer id){
		int i = userService.deleteUserByid(id);
		ModelAndView mv = new ModelAndView();
		if(i!=0) {
			List<User> user = userService.selectUser();
			mv.addObject("user", user);
			mv.setViewName("admin");
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	
	}
}
