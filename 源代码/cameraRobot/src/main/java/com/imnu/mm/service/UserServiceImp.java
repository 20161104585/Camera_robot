package com.imnu.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.mm.mapper.AreasMapper;
import com.imnu.mm.mapper.UserMapper;
import com.imnu.mm.pojo.Areas;
import com.imnu.mm.pojo.AreasExample;
import com.imnu.mm.pojo.User;
import com.imnu.mm.pojo.UserExample;
@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AreasMapper areasMapper;
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
	
	//用户信息查询
	public User selectUserById(int userId) {
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(userId);
		List<User> list = userMapper.selectByExample(example);
		return list.isEmpty()?null :list.get(0);
	}
	//用户信息修改
	public boolean updateUserById(User user) {
		int result = userMapper.updateByPrimaryKeySelective(user);
		return result>0?true:false;
	}
	//三级联动-查询所有省
	public List<Areas> findAllProvince() {
		AreasExample example = new AreasExample();
		example.createCriteria().andAreaTypeEqualTo("1");
		List<Areas> list = areasMapper.selectByExample(example);
		return list;
	}
	//三级联动-查询所有市
	public List<Areas> findAllCityByProvincename(String provincename) {
		AreasExample example = new AreasExample();
		example.createCriteria().andParentIdEqualTo(provincename);
		List<Areas> list = areasMapper.selectByExample(example);
		return list;
	}
	//三级联动-查询所有区
	public List<Areas> findAllCountyBycityname(String cityname) {
		AreasExample example = new AreasExample();
		example.createCriteria().andParentIdEqualTo(cityname);
		List<Areas> list = areasMapper.selectByExample(example);
		return list;
	}
	//判断用户名是否重复
	public Boolean checkUsername(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
    	System.out.println("结果返回成功123123123！！！");
		return list.isEmpty();
	}

	//获取所有用户信息
	public List<User> selectUser() {
		List<User> list = userMapper.selectByExample(null);
		return list.isEmpty()?null :list;
	}
	
	//模糊查询用户信息
	public List<User> searchUserByLike(String searchInfo){
		List<User> list = userMapper.selectByLike(searchInfo);
		return list.isEmpty()?null :list;
	}
	
	
	//删除用户
	public boolean deleteUserByid(int id) {
		int result = userMapper.deleteByPrimaryKey(id);
		return result>0?true:false;
	}
	
}
