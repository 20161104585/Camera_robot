package com.imnu.mm.mapper;

import com.imnu.mm.pojo.Phototype;
import com.imnu.mm.pojo.PhototypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhototypeMapper {
    int countByExample(PhototypeExample example);

    int deleteByExample(PhototypeExample example);

    int deleteByPrimaryKey(Integer typeid);

    int insert(Phototype record);

    int insertSelective(Phototype record);

    List<Phototype> selectByExample(PhototypeExample example);

    Phototype selectByPrimaryKey(Integer typeid);

    int updateByExampleSelective(@Param("record") Phototype record, @Param("example") PhototypeExample example);

    int updateByExample(@Param("record") Phototype record, @Param("example") PhototypeExample example);

    int updateByPrimaryKeySelective(Phototype record);

    int updateByPrimaryKey(Phototype record);
}