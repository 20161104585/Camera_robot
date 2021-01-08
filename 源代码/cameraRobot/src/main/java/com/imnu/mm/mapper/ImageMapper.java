package com.imnu.mm.mapper;

import com.imnu.mm.pojo.Image;
import com.imnu.mm.pojo.ImageExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ImageMapper {
    int countByExample(ImageExample example);

    int deleteByExample(ImageExample example);

    int deleteByPrimaryKey(Integer imgid);

    int insert(Image record);

    int insertSelective(Image record);

    List<Image> selectByExampleWithBLOBs(ImageExample example);

    List<Image> selectByExample(ImageExample example);

    Image selectByPrimaryKey(Integer imgid);

    int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByExampleWithBLOBs(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKeyWithBLOBs(Image record);

    int updateByPrimaryKey(Image record);
    
    @Select("select * from image where imgid like '%${searchInfo}%' or username like '%${searchInfo}%'")
	public List<Image> selectByLike(@Param(value="searchInfo") String searchInfo);
}