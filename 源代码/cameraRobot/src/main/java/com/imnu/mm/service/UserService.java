package com.imnu.mm.service;

import java.util.List;

import com.imnu.mm.pojo.Areas;
import com.imnu.mm.pojo.User;

public interface UserService {

	public User login(User user);
	
	public int register(User user);
	
	public User selectUserById(int userId);
	
	public boolean updateUserById(User user);
	
	public List<Areas> findAllProvince();
	
	public List<Areas> findAllCityByProvincename(String provincename);
	
	public List<Areas> findAllCountyBycityname(String cityname);

	public Boolean checkUsername(String username);

	public List<User> selectUser();
	
	public List<User> searchUserByLike(String searchInfo);

	public boolean deleteUserByid(int id);
}
