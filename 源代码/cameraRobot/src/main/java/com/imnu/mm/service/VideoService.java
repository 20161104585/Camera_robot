package com.imnu.mm.service;

import java.util.Date;
import java.util.List;

import com.imnu.mm.pojo.VideoWithBLOBs;

public interface VideoService {
	public boolean addVideo(VideoWithBLOBs video);
	
	public List<VideoWithBLOBs> selectVideo();
	
	public List<VideoWithBLOBs> selectVideoByUserid(int userId);
	
	public List<VideoWithBLOBs> selectVideoBydate(Date date1, Date date2);
	
	public List<VideoWithBLOBs> selectVideoBydateAndUserid(Date date1, Date date2,int userId);
	
	public boolean deleteVideo(int videoId);
	
	public VideoWithBLOBs selectVideoById(int videoId);
	
	public List<VideoWithBLOBs> selectVideoByLike(String searchInfo);
	
}
