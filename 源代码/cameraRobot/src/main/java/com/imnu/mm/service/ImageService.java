package com.imnu.mm.service;

import java.util.Date;
import java.util.List;

import com.imnu.mm.pojo.Image;

public interface ImageService {
	public List<Image> selectImage();
	
	public List<Image> selectImageByUserid(int userId);
	
	public List<Image> selectImageByImgdate(Date date1,Date date2);
	
	public List<Image> selectImageByImgdateAndUserid(Date date1,Date date2,int userId);
	
	public List<Image> selectImageByLike(String searchInfo);
	
	public Image selectImageById(int imgId);
	
	public boolean addImage(Image image);
	
	public boolean deleteImage(int imageId);
	
}
