package com.imnu.mm.service;

import java.util.Date;
import java.util.List;

import com.imnu.mm.pojo.Photo;

public interface PhotoService {
	
	public List<Photo> selectPhoto();
	
	public Photo selectPhotoById(int photoId);
	
	public List<Photo> selectPhotoByType(int type);
	
	public List<Photo> selectPhotoByLike(String searchInfo);
	
	public List<Photo> selectPhotoBydate(Date date1,Date date2);
	
	public boolean addPhoto(Photo photo);
	
	public boolean deletePhotoByid(int photoId);
	
	public boolean updatePhotoByid(Photo photo);
}
