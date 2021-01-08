package com.imnu.mm.mapper;

import com.imnu.mm.pojo.Robot;
import com.imnu.mm.pojo.RobotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RobotMapper {
    int countByExample(RobotExample example);

    int deleteByExample(RobotExample example);

    int deleteByPrimaryKey(Integer deviceid);

    int insert(Robot record);

    int insertSelective(Robot record);

    List<Robot> selectByExample(RobotExample example);

    Robot selectByPrimaryKey(Integer deviceid);

    int updateByExampleSelective(@Param("record") Robot record, @Param("example") RobotExample example);

    int updateByExample(@Param("record") Robot record, @Param("example") RobotExample example);

    int updateByPrimaryKeySelective(Robot record);

    int updateByPrimaryKey(Robot record);
}