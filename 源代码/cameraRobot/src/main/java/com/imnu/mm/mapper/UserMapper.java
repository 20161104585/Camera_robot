package com.imnu.mm.mapper;

import com.imnu.mm.pojo.User;
import com.imnu.mm.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select("select * from user where id like '%${searchInfo}%' or username like '%${searchInfo}%' or name like '%${searchInfo}%'")
	public List<User> selectByLike(@Param(value="searchInfo") String searchInfo);
}