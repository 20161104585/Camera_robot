package com.imnu.mm.service;

import java.util.List;

import com.imnu.mm.pojo.Image;
import com.imnu.mm.pojo.Photo;
import com.imnu.mm.pojo.User;
import com.imnu.mm.pojo.VideoWithBLOBs;

public interface PagingService {
	public List<User> pageUsers(Integer pageIndex);
	
	public List<VideoWithBLOBs> pageVideos(Integer pageIndex);
	
	public List<VideoWithBLOBs> pageVideosByUid(int userId,Integer pageIndex);
	
	public List<Image> pageImages(Integer pageIndex);
	
	public List<Image> pageImagesByUid(int userId,Integer pageIndex);
	
	public List<Photo> pagePhotos(Integer pageIndex);
	
	public List<Photo> pagePhotosByUid(int userId,Integer pageIndex);
}
