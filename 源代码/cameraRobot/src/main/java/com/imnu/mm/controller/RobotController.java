package com.imnu.mm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imnu.mm.pojo.Robot;
import com.imnu.mm.pojo.User;
import com.imnu.mm.service.RobotService;
import com.imnu.mm.service.UserService;

@Controller
@RequestMapping("/robots")
public class RobotController {

	@Autowired
	private UserService userService;
	@Autowired
	private RobotService robotService;
	//跳转主页
	@RequestMapping(value = "/tables",produces = "text/html;charset=utf-8")
	@ResponseBody
	public ModelAndView tablesPage(int userId){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			//管理员
			if(u.getType()==1) {
				List<Robot> robot = robotService.selectRobot();
				mv.addObject("user", u);
				mv.addObject("robotList", robot);
				mv.setViewName("message/tables");
				return mv;
			}else {
				//用户
				List<Robot> robot = robotService.selectRobotByUserid(u.getId());
				mv.addObject("user", u);
				mv.addObject("robotList", robot);
				mv.setViewName("message/tables");
				return mv;
			}
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	
	//新增设备页面
	@RequestMapping(value = "/addDevice",produces = "text/html;charset=utf-8")
	public ModelAndView addDevicePage(int userId){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			mv.setViewName("message/addDevice");
			mv.addObject("user", u);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	//新增设备信息
	@RequestMapping(value = "/addRobot",produces = "text/html;charset=utf-8")
	public ModelAndView addDevice(Robot robot,int userId){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			User robotuser = userService.selectUserById(robot.getUserid());
			robot.setUsername(robotuser.getUsername());
			boolean re = robotService.addRobot(robot);
			List<Robot> rob = robotService.selectRobot();
			if(re) {
				mv.addObject("user", u);
				mv.addObject("robotList", rob);
				mv.setViewName("message/tables");
				return mv;
			}else {
				mv.setViewName("redirect:/login.jsp");
				return mv;
			}
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	//修改设备页面
	@RequestMapping(value = "/updateDevice",produces = "text/html;charset=utf-8")
	public ModelAndView updateDevicePage(int userId,int deviceId){
		User u = userService.selectUserById(userId);
		Robot robot = robotService.selectRobotById(deviceId);
		ModelAndView mv = new ModelAndView();
		if(u!=null&&robot!=null) {	
			mv.setViewName("message/updateDevice");
			mv.addObject("user", u);
			mv.addObject("robot", robot);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	//修改设备信息
	@RequestMapping(value = "/updateRobot",produces = "text/html;charset=utf-8")
	@ResponseBody
	public ModelAndView updateDevice(Robot robot,int userId){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			User robotuser = userService.selectUserById(robot.getUserid());
			robot.setUsername(robotuser.getUsername());
			boolean re = robotService.updateRobotById(robot);
			List<Robot> rob = robotService.selectRobot();
			if(re) {
				mv.addObject("user", u);
				mv.addObject("robotList", rob);
				mv.setViewName("message/tables");
				return mv;
			}else {
				mv.setViewName("redirect:/login.jsp");
				return mv;
			}
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	//查看设备页面
	@RequestMapping(value = "/detailDevice",produces = "text/html;charset=utf-8")
	public ModelAndView detailDevicePage(int userId,int deviceId){
		User u = userService.selectUserById(userId);
		Robot robot = robotService.selectRobotById(deviceId);
		ModelAndView mv = new ModelAndView();
		if(u!=null&&robot!=null) {	
			System.out.println(robot.getDevicename());
			mv.setViewName("message/detailDevice");
			mv.addObject("user", u);
			mv.addObject("robot", robot);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	//删除设备
	@RequestMapping(value = "/deleteDevice",produces = "text/html;charset=utf-8")
	public ModelAndView deleteRobot(int userId,int deviceId){
		User u = userService.selectUserById(userId);
		boolean re = robotService.deleteRobot(deviceId);
		ModelAndView mv = new ModelAndView();
		if(u!=null&re) {
			List<Robot> rob = robotService.selectRobot();
			mv.addObject("user", u);
			mv.addObject("robotList", rob);
			mv.setViewName("message/tables");
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
}
