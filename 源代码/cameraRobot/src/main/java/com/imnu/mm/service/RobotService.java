package com.imnu.mm.service;

import java.util.List;

import com.imnu.mm.pojo.Robot;

public interface RobotService {
	public List<Robot> selectRobot();
	public List<Robot> selectRobotByUserid(int userId);
	public boolean addRobot(Robot robot);
	public boolean deleteRobot(int deviceId);
	public Robot selectRobotById(int deviceId);
	public boolean updateRobotById(Robot robot);
}
