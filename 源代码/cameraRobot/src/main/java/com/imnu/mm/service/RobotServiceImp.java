package com.imnu.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.mm.mapper.RobotMapper;
import com.imnu.mm.pojo.Robot;
import com.imnu.mm.pojo.RobotExample;
@Service
@Transactional
public class RobotServiceImp implements RobotService {

	@Autowired
	private RobotMapper robotMapper;
	
	//显示所有设备信息
	@Override
	public List<Robot> selectRobot() {
		RobotExample example = new RobotExample();
		List<Robot> list = robotMapper.selectByExample(example);
		return list.isEmpty()?null :list;
	}
	
	//显示已授权设备信息
	@Override
	public List<Robot> selectRobotByUserid(int userId) {
		RobotExample example = new RobotExample();
		example.createCriteria().andUseridEqualTo(userId);
		List<Robot> list = robotMapper.selectByExample(example);
		return list.isEmpty()?null :list;
	}
	
	//新增设备信息
	@Override
	public boolean addRobot(Robot robot) {
		int result = robotMapper.insert(robot);
		return result>0?true:false;
	}
	
	//删除设备信息
	@Override
	public boolean deleteRobot(int deviceId) {
		int result = robotMapper.deleteByPrimaryKey(deviceId);
		return result>0?true:false;
	}
	
	//查看设备信息
	@Override
	public Robot selectRobotById(int deviceId) {
		RobotExample example = new RobotExample();
		example.createCriteria().andDeviceidEqualTo(deviceId);
		List<Robot> list = robotMapper.selectByExample(example);	
		return list.isEmpty()?null :list.get(0);
	}
	
	//修改设备信息
	@Override
	public boolean updateRobotById(Robot robot) {
		int result = robotMapper.updateByPrimaryKeySelective(robot);	
		return result>0?true:false;
	}
	
}
