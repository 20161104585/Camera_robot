package com.imnu.mm.mapper;

import com.imnu.mm.pojo.Photo;
import com.imnu.mm.pojo.PhotoExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PhotoMapper {
    int countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(Integer photoid);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExampleWithBLOBs(PhotoExample example);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(Integer photoid);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExampleWithBLOBs(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKeyWithBLOBs(Photo record);

    int updateByPrimaryKey(Photo record);
    
    @Select("select * from photo where photoid like '%${searchInfo}%' or title like '%${searchInfo}%' or username like '%${searchInfo}%'")
	public List<Photo> selectByLike(@Param(value="searchInfo") String searchInfo);
}