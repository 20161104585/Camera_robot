package com.imnu.mm.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.mm.mapper.ImageMapper;
import com.imnu.mm.pojo.Image;
import com.imnu.mm.pojo.ImageExample;

@Service
@Transactional
public class ImageServiceImp implements ImageService {

	@Autowired
	private ImageMapper imageMapper;
	
	//显示所有图片信息
	@Override
	public List<Image> selectImage() {
		ImageExample example = new ImageExample();
		List<Image> list = imageMapper.selectByExample(example);;
		return list.isEmpty()?null :list;
	}
	
	//显示用户图片信息
	@Override
	public List<Image> selectImageByUserid(int userId) {
		ImageExample example = new ImageExample();
		example.createCriteria().andUseridEqualTo(userId);
		List<Image> list = imageMapper.selectByExample(example);
		return list.isEmpty()?null :list;
	}
	
	//日期搜索
	@Override
	public List<Image> selectImageByImgdate(Date date1,Date date2) {
		ImageExample example = new ImageExample();
		example.createCriteria().andImgdatetimeBetween(date1, date2);
		List<Image> list = imageMapper.selectByExampleWithBLOBs(example);
		return list.isEmpty()?null :list;
	}
	
	//日期搜索
	@Override
	public List<Image> selectImageByImgdateAndUserid(Date date1,Date date2,int userId) {
		ImageExample example = new ImageExample();
		example.createCriteria().andImgdatetimeBetween(date1, date2).andUseridEqualTo(userId);
		List<Image> list = imageMapper.selectByExampleWithBLOBs(example);
		return list.isEmpty()?null :list;
	}
	
	//模糊查询
	@Override
	public List<Image> selectImageByLike(String searchInfo) {
		List<Image> list = imageMapper.selectByLike(searchInfo);
		return list.isEmpty()?null :list;
	}
	
	//根据id查询摄影图片
	@Override
	public Image selectImageById(int imgId) {
		Image result = imageMapper.selectByPrimaryKey(imgId);
		return result;
	}
	
	//添加摄影图片
	@Override
	public boolean addImage(Image image) {
		int result = imageMapper.insertSelective(image);
		return result>0?true:false;
	}
	
	//删除摄影图片
	@Override
	public boolean deleteImage(int imageId) {
		int result = imageMapper.deleteByPrimaryKey(imageId);
		return result>0?true:false;
	}
}
