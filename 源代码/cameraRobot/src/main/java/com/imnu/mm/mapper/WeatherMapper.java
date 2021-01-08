package com.imnu.mm.mapper;

import com.imnu.mm.pojo.Weather;
import com.imnu.mm.pojo.WeatherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeatherMapper {
    int countByExample(WeatherExample example);

    int deleteByExample(WeatherExample example);

    int deleteByPrimaryKey(Integer weatherid);

    int insert(Weather record);

    int insertSelective(Weather record);

    List<Weather> selectByExample(WeatherExample example);

    Weather selectByPrimaryKey(Integer weatherid);

    int updateByExampleSelective(@Param("record") Weather record, @Param("example") WeatherExample example);

    int updateByExample(@Param("record") Weather record, @Param("example") WeatherExample example);

    int updateByPrimaryKeySelective(Weather record);

    int updateByPrimaryKey(Weather record);
}