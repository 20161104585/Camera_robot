package com.imnu.mm.mapper;

import com.imnu.mm.pojo.Video;
import com.imnu.mm.pojo.VideoExample;
import com.imnu.mm.pojo.VideoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer videoid);

    int insert(VideoWithBLOBs record);

    int insertSelective(VideoWithBLOBs record);

    List<VideoWithBLOBs> selectByExampleWithBLOBs(VideoExample example);

    List<Video> selectByExample(VideoExample example);

    VideoWithBLOBs selectByPrimaryKey(Integer videoid);

    int updateByExampleSelective(@Param("record") VideoWithBLOBs record, @Param("example") VideoExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoWithBLOBs record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(VideoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(VideoWithBLOBs record);

    int updateByPrimaryKey(Video record);
    
    @Select("select * from video where videoid like '%${searchInfo}%' or username like '%${searchInfo}%'")
	public List<VideoWithBLOBs> selectByLike(@Param(value="searchInfo") String searchInfo);
}