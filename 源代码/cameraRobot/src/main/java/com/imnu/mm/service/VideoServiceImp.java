package com.imnu.mm.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.mm.mapper.VideoMapper;
import com.imnu.mm.pojo.VideoExample;
import com.imnu.mm.pojo.VideoWithBLOBs;

@Service
@Transactional
public class VideoServiceImp implements VideoService {

	@Autowired
	private VideoMapper videoMapper;
	
	//显示所有视频信息  
	@Override 
	public List<VideoWithBLOBs> selectVideo() { 
		VideoExample example =new VideoExample(); 
		List<VideoWithBLOBs> list = videoMapper.selectByExampleWithBLOBs(example);
		return list.isEmpty()?null :list;
	}
	
	//显示用户视频信息  
	@Override 
	public List<VideoWithBLOBs> selectVideoByUserid(int userId) { 
		VideoExample example =new VideoExample(); 
		example.createCriteria().andUseridEqualTo(userId);
		List<VideoWithBLOBs> list = videoMapper.selectByExampleWithBLOBs(example);
		return list.isEmpty()?null :list;
	}
	
	//上传视频
	@Override
	public boolean addVideo(VideoWithBLOBs video) {
		int result = videoMapper.insert(video);
		return result>0?true:false;
	}
	
	//删除视频信息
	@Override 
	public boolean deleteVideo(int videoId) {
		int result = videoMapper.deleteByPrimaryKey(videoId); 
		return result>0?true:false; 
	} 
	  
	//查看视频信息  
	@Override 
	public VideoWithBLOBs selectVideoById(int videoId) { 
		VideoExample example =new VideoExample();
		example.createCriteria().andVideoidEqualTo(videoId);
		List<VideoWithBLOBs> list = videoMapper.selectByExampleWithBLOBs(example); 
		return list.isEmpty()?null :list.get(0); 
	}
	
	//管理员根据date查询视频  
	@Override 
	public List<VideoWithBLOBs> selectVideoBydate(Date date1, Date date2){
		VideoExample example = new VideoExample();
		example.createCriteria().andVideodatetimeBetween(date1, date2);
		List<VideoWithBLOBs> list = videoMapper.selectByExampleWithBLOBs(example);
		return list.isEmpty()?null :list;
	}
	
	//用户根据date查询视频  
	@Override 
	public List<VideoWithBLOBs> selectVideoBydateAndUserid(Date date1, Date date2,int userId){
		VideoExample example = new VideoExample();
		example.createCriteria().andVideodatetimeBetween(date1, date2).andUseridEqualTo(userId);
		List<VideoWithBLOBs> list = videoMapper.selectByExampleWithBLOBs(example);
		return list.isEmpty()?null :list;
	}
	
	//模糊查询
	@Override
	public List<VideoWithBLOBs> selectVideoByLike(String searchInfo) {
		List<VideoWithBLOBs> list = videoMapper.selectByLike(searchInfo);
		return list.isEmpty()?null :list;
	}
}
