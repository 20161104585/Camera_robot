package com.imnu.mm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imnu.mm.pojo.Image;
import com.imnu.mm.pojo.PagePojo;
import com.imnu.mm.pojo.Photo;
import com.imnu.mm.pojo.User;
import com.imnu.mm.service.PagingService;
import com.imnu.mm.service.PhotoService;
import com.imnu.mm.service.UserService;

@Controller
@RequestMapping("/photos")
public class PhotoController {

	@Autowired
	private UserService userService;
	@Autowired
	private PhotoService photoService;
	@Autowired
	private PagingService pagingService;
	
	//显示所有摄影作品
	@RequestMapping(value = "/photoInfo",produces = "text/html;charset=utf-8")
	public ModelAndView photoInfo(int userId,Integer pageNum){
		if(pageNum==0) {
			pageNum++;
		}
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			List<Photo> photoList = photoService.selectPhoto();
			PagePojo<Photo> pagePojo = new PagePojo();
			//分页显示
			if(photoList!=null) {
				Integer pageNumber = photoList.size();
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
				photoList =pagingService.pagePhotos(pageIndex);
				
				mv.addObject("user", u);
				mv.addObject("photoList", photoList);
				mv.addObject("pagePojo", pagePojo);
				mv.setViewName("message/photoInfo");
				return mv;
			}else {
				mv.addObject("photoList", photoList);
				mv.addObject("user", u);
				mv.setViewName("message/photoInfo");
				return mv;
			}
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	//摄影作品搜索
	@RequestMapping(value = "/searchPhotoByLike",produces = "text/html;charset=utf-8")
	public ModelAndView selectByPhototype(int userId,int selectType,String imgDate,String searchInfo){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			List<Photo> photoList = null;
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
				photoList = photoService.selectPhotoBydate(date1, date2);
			}else {
				photoList = photoService.selectPhotoByLike(searchInfo);
			}			
			mv.addObject("photoList", photoList);
			mv.addObject("user", u);
			mv.setViewName("message/photoInfo");
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}	
	
	
	//摄影作品展示
	@RequestMapping(value = "/show",produces = "text/html;charset=utf-8")
	public ModelAndView imgInfoPage(){
		System.out.println("show成功");
		ModelAndView mv = new ModelAndView();
		List<Photo> photos1 = photoService.selectPhotoByType(1);
		List<Photo> photos2 = photoService.selectPhotoByType(2);
		List<Photo> photos3 = photoService.selectPhotoByType(3);
		List<Photo> photos4 = photoService.selectPhotoByType(4);
		mv.addObject("photos1", photos1);
		mv.addObject("photos2", photos2);
		mv.addObject("photos3", photos3);
		mv.addObject("photos4", photos4);
		mv.setViewName("message/photoShow");
		return mv;
	}
	
    //删除作品
    @RequestMapping(value="/deletePhoto",produces = "text/html;charset=utf-8")
	public ModelAndView deletePhoto(int userId,int photoId){
    	Integer pageNum = 0;
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			boolean re = photoService.deletePhotoByid(photoId);
			if(re) {
				mv = photoInfo(userId,pageNum);
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
    
    
    //修改作品页面
    @RequestMapping(value="/updatePhotoPage",produces = "text/html;charset=utf-8")
	public ModelAndView updatePhotoPage(int userId,int photoId){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			Photo photo = photoService.selectPhotoById(photoId);
			if(photo!=null) {
				mv.addObject("user", u);
				mv.addObject("photo", photo);
				mv.setViewName("message/photoUpdate");
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
    
    //修改作品
    @RequestMapping(value="/updatePhoto",produces = "text/html;charset=utf-8")
	public ModelAndView updatePhoto(int userId,Photo photo){
    	Integer pageNum = 0;
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			boolean re = photoService.updatePhotoByid(photo);
			if(re) {
				mv = photoInfo(userId,pageNum);
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
