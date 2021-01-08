package com.imnu.mm.mapper;

import com.imnu.mm.pojo.Areas;
import com.imnu.mm.pojo.AreasExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreasMapper {
    int countByExample(AreasExample example);

    int deleteByExample(AreasExample example);

    int deleteByPrimaryKey(String areaId);

    int insert(Areas record);

    int insertSelective(Areas record);

    List<Areas> selectByExample(AreasExample example);

    Areas selectByPrimaryKey(String areaId);

    int updateByExampleSelective(@Param("record") Areas record, @Param("example") AreasExample example);

    int updateByExample(@Param("record") Areas record, @Param("example") AreasExample example);

    int updateByPrimaryKeySelective(Areas record);

    int updateByPrimaryKey(Areas record);
}