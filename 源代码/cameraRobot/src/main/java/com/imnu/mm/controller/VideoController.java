package com.imnu.mm.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.imnu.mm.pojo.PagePojo;
import com.imnu.mm.pojo.User;
import com.imnu.mm.pojo.VideoWithBLOBs;
import com.imnu.mm.service.PagingService;
import com.imnu.mm.service.UserService;
import com.imnu.mm.service.VideoService;

@Controller
@RequestMapping("/videos")
public class VideoController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private VideoService videoService;
	@Autowired
	private PagingService pagingService;
	//跳转视频主页
	@RequestMapping(value = "/charts",produces = "text/html;charset=utf-8")
	public ModelAndView chartsPage(int userId,Integer pageNum){
		if(pageNum==0) {
			pageNum++;
		}	
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			List<VideoWithBLOBs> videoList;
			if(u.getType()==1) {
				//管理员
				videoList = videoService.selectVideo();
			}else {
				//用户
				videoList = videoService.selectVideoByUserid(userId);
			}

			PagePojo<VideoWithBLOBs> pagePojo = new PagePojo();
			if(videoList!=null) {
				Integer pageNumber = videoList.size();
				Integer pageCount;
				if(pageNumber%10==0) {
					pageCount = pageNumber/10;
				}else {
					pageCount = pageNumber/10+1;
				}
				pagePojo.setPageNumber(pageNumber);
				pagePojo.setPageCount(pageCount);
				pagePojo.setPageIndex(pageNum);
				Integer pageIndex = (pageNum-1)*10;
				
				if(u.getType()==1) {
					//管理员
					videoList = pagingService.pageVideos(pageIndex);
				}else {
					//用户
					videoList = pagingService.pageVideosByUid(userId, pageIndex);
				}
				
				mv.addObject("user", u);
				mv.addObject("videoList", videoList);
				mv.addObject("pagePojo", pagePojo);
				mv.setViewName("message/charts");
				return mv;
			}else {
				mv.addObject("user", u);
				mv.addObject("videoList", videoList);
				mv.setViewName("message/charts");
				return mv;
			}	
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	//管理员----监控视频搜索
	@RequestMapping(value = "/selectVideo",produces = "text/html;charset=utf-8")
	public ModelAndView selectVideo(int userId,int selectType,String imgDate,String searchInfo){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			List<VideoWithBLOBs> videoList = null;
			if(selectType==2) {
				String str1 = imgDate.substring(0,10);
				String str2 = imgDate.substring(13,23);	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date1 = null;
				Date date2 = null;	
				try {
					date1 = sdf.parse(str1);
					date2 = sdf.parse(str2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				videoList = videoService.selectVideoBydate(date1, date2);
			}else {
				videoList = videoService.selectVideoByLike(searchInfo);
			}		
			mv.addObject("user", u);
			mv.addObject("videoList", videoList);
			mv.setViewName("message/charts");
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
		
	//用户---日期搜索视频
	@RequestMapping(value = "/selectUserVideo",produces = "text/html;charset=utf-8")
	public ModelAndView selectUserVideo(int userId,String imgDate){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			String str1 = imgDate.substring(0,10);
			String str2 = imgDate.substring(13,23);	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = null;
			Date date2 = null;	
			try {
				date1 = sdf.parse(str1);
				date2 = sdf.parse(str2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<VideoWithBLOBs> videoList = videoService.selectVideoBydateAndUserid(date1, date2, userId);
			mv.addObject("user", u);
			mv.addObject("videoList", videoList);
			mv.setViewName("message/charts");
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	
	//视频上传页面
	@RequestMapping(value = "/uploadPage",produces = "text/html;charset=utf-8")
	public ModelAndView uploadPage(int userId){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			mv.setViewName("message/videoUpload");
			mv.addObject("user", u);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	

	//视频上传
	@RequestMapping(value = "/upload",produces = "text/html;charset=utf-8")
	public ModelAndView uploadflie_Video(MultipartFile file,VideoWithBLOBs video,int userId) {
		System.out.println("进入addVideo视频上传控制层");
		if (file.getSize() > 0) {
			//获取视频大小
			String size = "";
			long fileLength = file.getSize();
			DecimalFormat df = new DecimalFormat("#.00");
			if (fileLength < 1024) {
				size = df.format((double) fileLength) + "BT";
			} else if (fileLength < 1048576) {
				size = df.format((double) fileLength / 1024) + "KB";
			} else if (fileLength < 1073741824) {
				size = df.format((double) fileLength / 1048576) + "MB";
			} else {
				size = df.format((double) fileLength / 1073741824) + "GB";
			}
			
			
			//上传的多格式的视频文件-作为临时路径保存，转码以后删除-路径不能写//
			//String path = "E:/Projectpicture/websiteimages/temp/";
			String path = "D://Program Files (x86)/Camera_robot/video/temp/";
			File TempFile = new File(path);
			if (TempFile.exists()) {
				if (TempFile.isDirectory()) {
					System.out.println("该文件夹存在。");
				}else {
					 System.out.println("同名的文件存在，不能创建文件夹。");
				}
			}else {
				 System.out.println("文件夹不存在，创建该文件夹。");
				 TempFile.mkdir();
			}
			
			// 获取上传时候的文件名
			String filename = file.getOriginalFilename();
			
			// 获取文件后缀名
			String filename_extension = filename.substring(filename
					.lastIndexOf(".") + 1);
			System.out.println("视频的后缀名:"+filename_extension);
			
			//时间戳做新的文件名，避免中文乱码-重新生成filename
			long filename1 = new Date().getTime();
			filename = Long.toString(filename1)+"."+filename_extension;
			
			//去掉后缀的文件名
			String filename2 = filename.substring(0, filename.lastIndexOf("."));
			System.out.println("视频名为:"+filename2);
			
			//源视频地址+重命名后的视频名+视频后缀
			String yuanPATH =(path+filename);  
			
			System.out.println("视频的完整文件名1:"+filename);
			System.out.println("源视频路径为:"+yuanPATH);
			
			//上传到本地磁盘/服务器
			try {
				System.out.println("写入本地磁盘/服务器");
				InputStream is = file.getInputStream();
				OutputStream os = new FileOutputStream(new File(path, filename));
				int len = 0;
				byte[] buffer = new byte[2048];
				
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.close();
				os.flush();
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("========上传完成，开始调用转码工具类=======");
			//调用转码机制flv mp4 f4v m3u8 webm ogg放行直接播放，
			//asx，asf，mpg，wmv，3gp，mov，avi，wmv9，rm，rmvb等进行其他转码为mp4
			if (filename_extension.equals("avi") || filename_extension.equals("rm") 
				|| filename_extension.equals("rmvb") || filename_extension.equals("wmv")
				|| filename_extension.equals("3gp")  || filename_extension.equals("mov")
				||filename_extension.equals("flv")   || filename_extension.equals("ogg")
				|| filename_extension.equals("mpg")  || filename_extension.equals("mp4")
				|| filename_extension.equals("asf")  || filename_extension.equals("asx")
				|| filename_extension.equals("mkv")
				
				) {
				
				ConverVideoTest c = new ConverVideoTest();
		        c.run(yuanPATH);   //调用转码
				System.out.println("=================转码过程彻底结束=====================");
			}
			
			//获取转码后的mp4文件名D:\Program Files (x86)\Camera_robot\video\finshVideo
			String Mp4path = "D://Program Files (x86)/Camera_robot/video/finshVideo/";
			String filename3 = filename2+".mp4";
			String videoimage = filename2+".jpg";
			String NewVideopath =Mp4path +filename3;
			System.out.println("新视频的url:"+NewVideopath);
			
			//删除临时文件
			File file2 = new File(path);
			 if (!file2.exists()) {
		       System.out.println("没有该文件");
		       }
		     if (!file2.isDirectory()) {
		    	   System.out.println("没有该文件夹");
		       }
		     String[] tempList = file2.list();
		     File temp = null;
		     for (int i = 0; i < tempList.length; i++) {
		          if (path.endsWith(File.separator)) {
		             temp = new File(path + tempList[i]);
		          } else {
		              temp = new File(path + File.separator + tempList[i]);
		          }
		          if (temp.isFile() || temp.isDirectory()) {
		             temp.delete();		//删除文件夹里面的文件
		          }
		        }
		       System.out.println("所有的临时视频文件删除成功");
			
			// 实例化用户类
	        User u = userService.selectUserById(userId);
	        //数据库存储信息
			video.setUserid(u.getId());
			video.setUsername(u.getUsername());
			video.setVideosize(size);				//文件的大小
			video.setVideotype(filename_extension);	//文件的类型
			video.setVideoname(filename3);
			video.setVideoimage(videoimage);
			video.setVideopath(NewVideopath);		//已转码后的视频存放地址
			// 实现对数据的更新
			boolean re = videoService.addVideo(video);
			ModelAndView mv = new ModelAndView();
			if(u!=null&&re) {
				List<VideoWithBLOBs> videoList = videoService.selectVideo();
				mv.addObject("videoList", videoList);
				mv.setViewName("message/charts");
				mv.addObject("user", u);
				return mv;
			}else {
				mv.setViewName("redirect:/login.jsp");
				return mv;
			}

		}
		return null;
	}
	
	//视频播放
	@RequestMapping(value = "/videoView",produces = "text/html;charset=utf-8")
	public ModelAndView videoView(int userId,int videoId) {
		System.out.println("进入videoView视频播放页控制层");
		
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			VideoWithBLOBs video = videoService.selectVideoById(videoId);
			mv.setViewName("message/videoView");
			mv.addObject("user", u);
			mv.addObject("video", video);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	//删除视频
	@RequestMapping(value = "/delVideo",produces = "text/html;charset=utf-8")
	public ModelAndView delVideo(int userId,int videoId) {
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			boolean re = videoService.deleteVideo(videoId);
			if(re) {
				Integer pageNum=1;
				mv = chartsPage(userId,pageNum);
				return mv;
			}else {
				mv.setViewName("redirect:/login.jsp");
				return mv;
			}
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
}
