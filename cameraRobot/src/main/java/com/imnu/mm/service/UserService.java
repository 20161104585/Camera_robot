package com.imnu.mm.service;

import java.util.List;

import com.imnu.mm.pojo.User;

public interface UserService {

	public User login(User user);
	
	public int register(User user);

	public Boolean checkUsername(String username);

	public List<User> selectUser();

	public int deleteUserByid(Integer id);
}
