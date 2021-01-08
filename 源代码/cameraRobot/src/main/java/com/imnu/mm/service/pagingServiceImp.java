package com.imnu.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imnu.mm.mapper.PageMapper;
import com.imnu.mm.pojo.Image;
import com.imnu.mm.pojo.Photo;
import com.imnu.mm.pojo.User;
import com.imnu.mm.pojo.VideoWithBLOBs;
@Service
public class pagingServiceImp implements PagingService {

	@Autowired
	private PageMapper pageMapper;
	
	@Override
	public List<User> pageUsers(Integer pageIndex) {
		List<User> userList = pageMapper.pageAllUsers(pageIndex);
		return userList.isEmpty()?null:userList;
	}
	
	@Override
	public List<VideoWithBLOBs> pageVideos(Integer pageIndex) {
		List<VideoWithBLOBs> videoList = pageMapper.pageAllVideos(pageIndex);
		return videoList.isEmpty()?null:videoList;
	}
	
	@Override
	public List<VideoWithBLOBs> pageVideosByUid(int userId,Integer pageIndex) {
		List<VideoWithBLOBs> videoList = pageMapper.pageVideosByUserid(userId, pageIndex);
		return videoList.isEmpty()?null:videoList;
	}
	
	@Override
	public List<Image> pageImages(Integer pageIndex) {
		List<Image> imageList = pageMapper.pageAllImages(pageIndex);
		return imageList.isEmpty()?null:imageList;
	}
	
	@Override
	public List<Image> pageImagesByUid(int userId,Integer pageIndex) {
		List<Image> imageList = pageMapper.pageImagesByUserid(userId, pageIndex);
		return imageList.isEmpty()?null:imageList;
	}
	
	@Override
	public List<Photo> pagePhotos(Integer pageIndex){
		List<Photo> photoList = pageMapper.pageAllPhotos(pageIndex);
		return photoList.isEmpty()?null:photoList;
	}
	
	@Override
	public List<Photo> pagePhotosByUid(int userId,Integer pageIndex){
		List<Photo> photoList = pageMapper.pagePhotosByUserid(userId, pageIndex);
		return photoList.isEmpty()?null:photoList;
	}
}
