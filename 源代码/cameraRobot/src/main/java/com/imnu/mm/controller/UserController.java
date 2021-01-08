package com.imnu.mm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.imnu.mm.pojo.Areas;
import com.imnu.mm.pojo.PagePojo;
import com.imnu.mm.pojo.Robot;
import com.imnu.mm.pojo.User;
import com.imnu.mm.service.PagingService;
import com.imnu.mm.service.RobotService;
import com.imnu.mm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RobotService robotService;
	@Autowired
	private PagingService pagingService;
	
	//登录
	@RequestMapping(value = "/login",produces = "text/html;charset=utf-8")
	public ModelAndView login(User user) {
		User u = userService.login(user);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			//管理员登陆
			if(u.getType()==1) {
				List<Robot> robot = robotService.selectRobot();
				mv.addObject("robotList", robot);
				mv.setViewName("message/index");
				mv.addObject("user", u);
				return mv;
			}else {
				//用户登陆
				List<Robot> robot = robotService.selectRobotByUserid(u.getId());
				mv.addObject("robotList", robot);
				mv.setViewName("message/index");
				mv.addObject("user", u);
				return mv;
			}
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	//用户注册
	@RequestMapping(value = "/register",produces = "text/html;charset=utf-8")
	public ModelAndView register(User user) {
		userService.register(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/login.jsp");
		return mv;
	}
	
	//管理员编辑用户信息页面
	@RequestMapping(value = "/updateUserInfoPage",produces = "text/html;charset=utf-8")
	public ModelAndView updateUserInfoPage(int userId,int id){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			User user = userService.selectUserById(id);
			mv.addObject("userinfo", user);
			mv.addObject("user", u);
			mv.setViewName("message/UserInfoPage");
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	//管理员修改用户信息
	@RequestMapping(value = "/updateUserInfo",produces = "text/html;charset=utf-8")
	public ModelAndView updateUserInfo(int userId,User user,MultipartFile file){
		Integer pageNum = 0;
		User u = userService.selectUserById(userId);
		String userImgName = uploadMultipartFile(file);
		user.setImg(userImgName);
		boolean re = userService.updateUserById(user);
		ModelAndView mv = new ModelAndView();
		if(u!=null&&re) {
			mv = userInfo(userId,pageNum);
			return mv;
		}else {
			mv.addObject("result", "插入失败");
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	
	//查询用户信息
	@RequestMapping(value = "/information",produces = "text/html;charset=utf-8")
	public ModelAndView information(int userId){
		System.out.println(userId);
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			mv.setViewName("message/information");
			mv.addObject("user", u);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	//修改用户信息
	@RequestMapping(value = "/updateUser",produces = "text/html;charset=utf-8")
	public ModelAndView updateUser(User user,MultipartFile file){
		Integer pageNum = 0;
		if(file.getSize() > 0) {
			String userImgName = uploadMultipartFile(file);
			user.setImg(userImgName);
		}
		boolean result = userService.updateUserById(user);
		ModelAndView mv = new ModelAndView();
		if(result) {
			//管理员登陆
			if(user.getType()==1) {
				User u = userService.selectUserById(user.getId());
				List<Robot> robot = robotService.selectRobot();
				mv.addObject("robotList", robot);
				mv.setViewName("message/index");
				mv.addObject("user", u);
				return mv;
			}else {
				//用户登陆
				User u = userService.selectUserById(user.getId());
				List<Robot> robot = robotService.selectRobotByUserid(u.getId());
				mv.addObject("robotList", robot);
				mv.setViewName("message/index");
				mv.addObject("user", u);
				return mv;
			}
		}else {
			mv.addObject("result", "插入失败");
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	//上传图片
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String uploadMultipartFile(MultipartFile file) {
		String filename = file.getOriginalFilename(); //原始文件名
		String newFileName = UUID.randomUUID().toString()+filename.substring(filename.lastIndexOf("."));
		File load = new File("D:/Program Files (x86)/Camera_robot/userImg/"+newFileName);
		try {
			file.transferTo(load);
			return newFileName;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	/**
	 * ajax三级联动
	 * @return
	 * 	一级联动
	 */
    @RequestMapping(value="/findAllProvince",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String province(){
    	List<Areas> provinceList = userService.findAllProvince();//省份
    	System.out.println("province加载完毕");
    	for (Areas thinkArueas : provinceList) {
			System.out.println(thinkArueas);
		}
		return JSON.toJSONString(provinceList);
	
	}
    //二级联动
    @RequestMapping(value="/findAllCityByProvincename",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String city(String provincename){
    	List<Areas> cityList = userService.findAllCityByProvincename(provincename);//省份
    	System.out.println("city加载完毕");
    	for (Areas thinkArueas : cityList) {
			System.out.println(thinkArueas);
		}
		return JSON.toJSONString(cityList);
	
	}
    //三级联动
    @RequestMapping(value="/findAllCountyBycityname",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String county(String cityname){
    	List<Areas> countyList = userService.findAllCountyBycityname(cityname);//省份
    	System.out.println("county加载完毕");
    	for (Areas thinkArueas : countyList) {
			System.out.println(thinkArueas);
		}
		return JSON.toJSONString(countyList);
	
	}
    //校验用户名是否存在
    @RequestMapping(value="/checkUsername",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String checkUname(String username){
    	int rs;
    	Boolean result = userService.checkUsername(username);
    	if(result==true) {
    		rs=1;//用户名不存在
    	}else {
    		rs=0;//用户名存在
    	}
		return JSON.toJSONString(rs);
	
	}
    //删除用户
    @RequestMapping(value="/deleteUser",produces = "text/html;charset=utf-8")
	public ModelAndView deleteUser(int userId,int id){
    	Integer pageNum = 0;
    	boolean re = userService.deleteUserByid(id);
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null&&re) {
			mv = userInfo(userId,pageNum);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
    
    //查询用户
    @RequestMapping(value="/searchUser",produces = "text/html;charset=utf-8")
	public ModelAndView searchUser(int userId,String searchInfo){
    	Integer pageNum = 0;
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			List<User> userList = userService.searchUserByLike(searchInfo);
			mv.addObject("userList", userList);
			mv.addObject("user", u);
			mv.setViewName("message/userInfo");
			return mv;

		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
    
	//用户管理
	@RequestMapping(value = "/userInfo",produces = "text/html;charset=utf-8")
	public ModelAndView userInfo(int userId,Integer pageNum) {
		if(pageNum==0) {
			pageNum++;
		}
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			List<User> userList = userService.selectUser();
			PagePojo<User> pagePojo = new PagePojo();
			//分页显示
			if(userList!=null) {
				Integer pageNumber = userList.size();
				Integer pageCount;
				if(pageNumber%10==0) {
					pageCount = pageNumber/10;
				}else {
					pageCount = pageNumber/10+1;
				}
				pagePojo.setPageNumber(pageNumber);
				pagePojo.setPageCount(pageCount);
				pagePojo.setPageIndex(pageNum);
				Integer pageIndex = (pageNum-1)*10;
				userList =pagingService.pageUsers(pageIndex);
				
				mv.addObject("user", u);
				mv.addObject("userList", userList);
				mv.addObject("pagePojo", pagePojo);
				mv.setViewName("message/userInfo");
				return mv;
			}else {
				mv.addObject("userList", userList);
				mv.addObject("user", u);
				mv.setViewName("message/userInfo");
				return mv;
			}			
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	//设备授权---查找所有用户
	@RequestMapping(value = "/findAllUser",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String findAllUser() {
		List<User> userList = userService.selectUser();
		return JSON.toJSONString(userList);

	}
	
	//注销用户
	@RequestMapping(value = "/outLogin",produces = "text/html;charset=utf-8")
	public String outLogin(HttpSession session){
		//通过session.invalidata()方法来注销当前的session
		System.out.println("注销用户");
		session.invalidate();
		return "redirect:/login.jsp";
	}

}
