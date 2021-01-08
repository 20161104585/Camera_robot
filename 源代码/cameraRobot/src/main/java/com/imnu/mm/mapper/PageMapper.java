package com.imnu.mm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.imnu.mm.pojo.Image;
import com.imnu.mm.pojo.Photo;
import com.imnu.mm.pojo.User;
import com.imnu.mm.pojo.VideoWithBLOBs;
@Mapper
@Repository
public interface PageMapper {
	@Select("select * from user limit #{pageIndex},10")
	public List<User> pageAllUsers(Integer pageIndex);
	
	@Select("select * from user where userID = #{id} limit #{pageIndex},10")
	public List<User> pageUserById(Integer pageIndex,int id);
	
	@Select("select * from video limit #{pageIndex},10")
	public List<VideoWithBLOBs> pageAllVideos(Integer pageIndex);
	
	@Select("select * from video where userID = #{userId} limit #{pageIndex},10")
	public List<VideoWithBLOBs> pageVideosByUserid(int userId,Integer pageIndex);
	
	@Select("select * from image limit #{pageIndex},10")
	public List<Image> pageAllImages(Integer pageIndex);
	
	@Select("select * from image where userID = #{userId} limit #{pageIndex},10")
	public List<Image> pageImagesByUserid(int userId,Integer pageIndex);
	
	@Select("select * from photo limit #{pageIndex},10")
	public List<Photo> pageAllPhotos(Integer pageIndex);
	
	@Select("select * from photo where userID = #{userId} limit #{pageIndex},10")
	public List<Photo> pagePhotosByUserid(int userId,Integer pageIndex);
}
