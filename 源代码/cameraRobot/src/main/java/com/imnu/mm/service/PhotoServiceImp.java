package com.imnu.mm.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.mm.mapper.PhotoMapper;
import com.imnu.mm.pojo.Photo;
import com.imnu.mm.pojo.PhotoExample;

@Service
@Transactional
public class PhotoServiceImp implements PhotoService {

	@Autowired
	private PhotoMapper photoMapper;
	
	//查询所有作品
	@Override
	public List<Photo> selectPhoto() {
		List<Photo> list = photoMapper.selectByExample(null);
		return list.isEmpty()?null :list;
	}
	
	//根据id查询作品
	@Override
	public Photo selectPhotoById(int photoId) {
		PhotoExample example = new PhotoExample();
		example.createCriteria().andPhotoidEqualTo(photoId);
		List<Photo> list  = photoMapper.selectByExampleWithBLOBs(example);
		return list.isEmpty()?null :list.get(0);
	}
	
	//根据类型查找作品
	@Override
	public List<Photo> selectPhotoByType(int type) {
		PhotoExample example = new PhotoExample();
		example.createCriteria().andTypeEqualTo(type);
		List<Photo> list = photoMapper.selectByExample(example);
		return list.isEmpty()?null :list;
	}
	
	//关键字模糊查找作品
	@Override
	public List<Photo> selectPhotoByLike(String searchInfo) {		
		List<Photo> list = photoMapper.selectByLike(searchInfo);
		return list.isEmpty()?null :list;
	}
	
	//日期搜索
	@Override
	public List<Photo> selectPhotoBydate(Date date1,Date date2) {
		PhotoExample example = new PhotoExample();
		example.createCriteria().andDatetimeBetween(date1, date2);
		List<Photo> list = photoMapper.selectByExampleWithBLOBs(example);
		return list.isEmpty()?null :list;
	}
	
	//新增作品信息
	@Override
	public boolean addPhoto(Photo photo) {
		int result = photoMapper.insert(photo);
		return result>0?true:false;
	}
	
	//删除作品
	@Override
	public boolean deletePhotoByid(int photoId) {
		int result = photoMapper.deleteByPrimaryKey(photoId);
		return result>0?true:false;
	}
	
	//修改作品
	@Override
	public boolean updatePhotoByid(Photo photo) {
		int result = photoMapper.updateByPrimaryKeySelective(photo);
		return result>0?true:false;
	}
}
