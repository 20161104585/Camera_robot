package com.imnu.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.imnu.mm.mapper.UserMapper;

import com.imnu.mm.pojo.User;
import com.imnu.mm.pojo.UserExample;
@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;
	//普通用户登录
	public User login(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<User> list = userMapper.selectByExample(example);
		return list.isEmpty()?null :list.get(0);
	}
	//用户注册
	public int register(User user) {
		int i = userMapper.insert(user);
		return i;
	}
//	//三级联动-查询所有省
//	public List<ThinkAreas> findAllProvince() {
//		ThinkAreasExample example = new ThinkAreasExample();
//		example.createCriteria().andAreaTypeEqualTo("1");
//		List<ThinkAreas> list = thinkAreasMapper.selectByExample(example);
//		return list;
//	}
//	//三级联动-查询所有市
//	public List<ThinkAreas> findAllCityByProvincename(String provincename) {
//		ThinkAreasExample example = new ThinkAreasExample();
//		example.createCriteria().andParentIdEqualTo(provincename);
//		List<ThinkAreas> list = thinkAreasMapper.selectByExample(example);
//		return list;
//	}
//	//三级联动-查询所有区
//	public List<ThinkAreas> findAllCountyBycityname(String cityname) {
//		ThinkAreasExample example = new ThinkAreasExample();
//		example.createCriteria().andParentIdEqualTo(cityname);
//		List<ThinkAreas> list = thinkAreasMapper.selectByExample(example);
//		return list;
//	}
	//判断用户名是否重复
	public Boolean checkUsername(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
    	System.out.println("结果返回成功123123123！！！");
		return list.isEmpty();
	}
//	//超级管理员登录
//	public Supadmin loginAdmin(Supadmin supadmin) {
//		SupadminExample example = new SupadminExample();
//		example.createCriteria().andAdmnameEqualTo(supadmin.getAdmname()).andAdmpwdEqualTo(supadmin.getAdmpwd());
//		List<Supadmin> list = supadminMapper.selectByExample(example);
//		return list.isEmpty()?null :list.get(0);
//	}
	//获取所有用户信息
	public List<User> selectUser() {
		List<User> list = userMapper.selectByExample(null);
		return list.isEmpty()?null :list;
	}
	public int deleteUserByid(Integer u_id) {
		int i = userMapper.deleteByPrimaryKey(u_id);
		return i;
	}
	
}
