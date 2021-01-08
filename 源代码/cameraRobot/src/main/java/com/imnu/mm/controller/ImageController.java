package com.imnu.mm.controller;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Decoder;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.imnu.mm.pojo.Image;
import com.imnu.mm.pojo.PagePojo;
import com.imnu.mm.pojo.Photo;
import com.imnu.mm.pojo.User;
import com.imnu.mm.service.ImageService;
import com.imnu.mm.service.PagingService;
import com.imnu.mm.service.PhotoService;
import com.imnu.mm.service.UserService;

@Controller
@RequestMapping("/images")
public class ImageController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private PhotoService photoService;
	@Autowired
	private PagingService pagingService;
	//跳转主页
	@RequestMapping(value = "/forms",produces = "text/html;charset=utf-8")
	@ResponseBody
	public ModelAndView formsPage(int userId,Integer pageNum){
		System.out.println("1.0成功");
		if(pageNum==0) {
			pageNum++;
		}	
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			List<Image> images;
			if(u.getType()==1) {
				//管理员
				images = imageService.selectImage();
			}else {
				//用户
				images = imageService.selectImageByUserid(userId);
			}
			//分页显示
			PagePojo<Image> pagePojo = new PagePojo();
			if(images!=null) {
				Integer pageNumber = images.size();
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
					images =pagingService.pageImages(pageIndex);
				}else {
					//用户
					images = pagingService.pageImagesByUid(userId, pageIndex);
				}
				mv.addObject("user", u);
				mv.addObject("images", images);
				mv.addObject("pagePojo", pagePojo);
				mv.setViewName("message/forms");
				return mv;
			}else {
				mv.addObject("user", u);
				mv.addObject("images", images);
				mv.setViewName("message/forms");
				return mv;
			}
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	//管理员---摄影图片搜索
	@RequestMapping(value = "/selectImg",produces = "text/html;charset=utf-8")
	@ResponseBody
	public ModelAndView selectImg(int userId,int selectType,String imgDate,String searchInfo){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			List<Image> images = null;
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
				images = imageService.selectImageByImgdate(date1, date2);
			}else {
				images = imageService.selectImageByLike(searchInfo);	
			}
			mv.addObject("user", u);
			mv.addObject("images", images);
			mv.setViewName("message/forms");
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	
	//用户---日期搜索
	@RequestMapping(value = "/selectUserImg",produces = "text/html;charset=utf-8")
	@ResponseBody
	public ModelAndView selectImg(int userId,String imgDate){
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
			//用户
			List<Image> images = imageService.selectImageByImgdateAndUserid(date1, date2, userId);
			mv.addObject("user", u);
			mv.addObject("images", images);
			mv.setViewName("message/forms");
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}

	}
	
	//添加图片
	@RequestMapping(value = "/addImage",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String addImage(int userId,String imageData){
		User u = userService.selectUserById(userId);
		Image image = new Image();
		if (u!=null&imageData!=null){
			Decoder decoder = Base64.getDecoder();
			// Base64解码
			try {
				byte[] b = decoder.decode(imageData);
				for (int i = 0; i < b.length; ++i) {
				   // 调整异常数据
				   if (b[i] < 0) {
				      b[i] += 256;
				   }
				}
		        // 生成jpeg图片
		        String photoName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+ ".jpg";
		        // 新生成的图片 
		        String imgFilePath = "D://Program Files (x86)/Camera_robot/photos/"+ photoName;
				OutputStream out = new FileOutputStream(imgFilePath);
				out.write(b);
				out.flush();
				out.close();
				image.setImgaddress(imgFilePath);
				image.setImgdatetime(new Date());
				image.setImgname(photoName);
				image.setUserid(u.getId());
				image.setUsername(u.getUsername());
				boolean re = imageService.addImage(image);
				if(re) {
					return JSON.toJSONString("1");
				}else {
					return JSON.toJSONString("0");
				}
	        } catch (Exception e) {
	        	return JSON.toJSONString("0");
	        }
		}else {
			return JSON.toJSONString("0");
		}
	}
		
	//上传图片
	@RequestMapping(value="/uploadImage",method=RequestMethod.POST)
	@ResponseBody
	public String uploadImage(int userId,String picUrl) {
		User u = userService.selectUserById(userId);
		Image image = new Image();
		if (u!=null&picUrl!=null){
			URL url = null;
	        try {
	            url = new URL(picUrl);
	            DataInputStream dataInputStream = new DataInputStream(url.openStream());
	            
	            // 新生成的图片 
	            String photoName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+ ".jpg";
	            String imgFilePath = "D://Program Files (x86)/Camera_robot/photos/"+ photoName;
	            FileOutputStream fileOutputStream = new FileOutputStream(new File(imgFilePath));
	            ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	            byte[] buffer = new byte[1024];
	            int length;
	 
	            while ((length = dataInputStream.read(buffer)) > 0) {
	                output.write(buffer, 0, length);
	            }
	            fileOutputStream.write(output.toByteArray());            
	            dataInputStream.close();
	            fileOutputStream.close();
	            
				image.setImgaddress(imgFilePath);
				image.setImgdatetime(new Date());
				image.setImgname(photoName);
				image.setUserid(u.getId());
				image.setUsername(u.getUsername());
				boolean re = imageService.addImage(image);
				if(re) {
					return JSON.toJSONString("success");
				}else {
					return JSON.toJSONString("error");
				}
	        }catch (IOException e) {
	            e.printStackTrace();
	            return JSON.toJSONString("error");
	        }
		}else {
			return JSON.toJSONString("error");
		}
	}	
	//上传作品页面
	@RequestMapping(value = "/imgInfoPage",produces = "text/html;charset=utf-8")
	public ModelAndView imgInfoPage(int userId,int imgId){
		User u = userService.selectUserById(userId);
		ModelAndView mv = new ModelAndView();
		if(u!=null) {
			Image image = imageService.selectImageById(imgId);
			mv.setViewName("message/imgInfo");
			mv.addObject("user", u);
			mv.addObject("image", image);
			return mv;
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	//上传作品
	@RequestMapping(value = "/imgInfo",produces = "text/html;charset=utf-8")
	public ModelAndView imgInfoPage(Photo photo,int userId){
		Integer pageNum = 1;
		User u = userService.selectUserById(userId);
		boolean re = photoService.addPhoto(photo);
		ModelAndView mv = new ModelAndView();
		if(u!=null&re){
			List<Image> images;
			if(u.getType()==1) {
				//管理员
				images = imageService.selectImage();
			}else {
				//用户
				images = imageService.selectImageByUserid(userId);
			}
			//分页显示
			PagePojo<Image> pagePojo = new PagePojo();
			if(images!=null) {
				Integer pageNumber = images.size();
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
					images =pagingService.pageImages(pageIndex);
				}else {
					//用户
					images = pagingService.pageImagesByUid(userId, pageIndex);
				}
				
				mv.addObject("user", u);
				mv.addObject("images", images);
				mv.addObject("pagePojo", pagePojo);
				mv.setViewName("message/forms");
				return mv;
			}else {
				mv.addObject("user", u);
				mv.addObject("images", images);
				mv.setViewName("message/forms");
				return mv;
			}
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
	
	//删除图片
	@RequestMapping(value = "/deleteImage",produces = "text/html;charset=utf-8")
	public ModelAndView deleteImage(int userId,int imageId){
		Integer pageNum = 1;
		User u = userService.selectUserById(userId);
		boolean re = imageService.deleteImage(imageId);
		ModelAndView mv = new ModelAndView();
		if(u!=null&re) {
			List<Image> images;
			if(u.getType()==1) {
				//管理员
				images = imageService.selectImage();
			}else {
				//用户
				images = imageService.selectImageByUserid(userId);
			}
			//分页显示
			PagePojo<Image> pagePojo = new PagePojo();
			if(images!=null) {
				Integer pageNumber = images.size();
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
					images =pagingService.pageImages(pageIndex);
				}else {
					//用户
					images = pagingService.pageImagesByUid(userId, pageIndex);
				}
				
				mv.addObject("user", u);
				mv.addObject("images", images);
				mv.addObject("pagePojo", pagePojo);
				mv.setViewName("message/forms");
				return mv;
			}else {
				mv.addObject("user", u);
				mv.addObject("images", images);
				mv.setViewName("message/forms");
				return mv;
			}
		}else {
			mv.setViewName("redirect:/login.jsp");
			return mv;
		}
	}
}
