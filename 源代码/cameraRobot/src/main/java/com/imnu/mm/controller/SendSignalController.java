package com.imnu.mm.controller;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.imnu.mm.pojo.Robot;
import com.imnu.mm.pojo.User;
import com.imnu.mm.service.RobotService;
import com.imnu.mm.service.SendSignalServiceImp;
import com.imnu.mm.service.UserService;

@Controller
@RequestMapping("/signal")
public class SendSignalController {

	@Autowired
	private UserService userService;
	@Autowired
	private RobotService robotService;
	//跳转主页
	@RequestMapping(value = "/index",produces = "text/html;charset=utf-8")
	public ModelAndView indexPage(int userId){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			List<Robot> robot = robotService.selectRobot();
			mv.addObject("robotList", robot);
			mv.setViewName("message/index");
			mv.addObject("user", u);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}

	//发送数据
	@RequestMapping(value="/text",produces = "text/html;charset=utf-8")
	@ResponseBody
	public void jsonSignal(String jsonStr,String ipaddress,int port){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			com.alibaba.fastjson.JSONObject json = JSON.parseObject(jsonStr);
			
			System.out.println("ipaddress:"+ipaddress+"port:"+port);
			System.out.println(jsonStr);
			System.out.println("left:"+json.getString("left"));			
			System.out.println("----------------------------------------");
				
			byte[] buf = jsonStr.getBytes();
			int length = buf.length;//数据的长度
			InetAddress address = InetAddress.getByName(ipaddress);//目标ip
			
			DatagramPacket dp = new DatagramPacket(buf, length, address, port);
			ds.send(dp);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ds!=null)
				ds.close();
		}	

	
	}
	
	@RequestMapping(value="/buildLink",produces = "text/html;charset=utf-8")
	@ResponseBody
	public void threadControl(String jsonStr){
		InetAddress address;
		int port;
		try {
			port = 8081;
			address = InetAddress.getByName("192.168.137.1");
			SendSignalServiceImp ssc = new SendSignalServiceImp(port,address);
			ssc.start();
			System.out.println(jsonStr);
			System.out.println("----------------------------------------");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
