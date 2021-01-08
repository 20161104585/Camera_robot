package com.imnu.mm.controller;

public class ConverVideoTest {
	
	/**
	 * @Description:(1.转码和截图功能调用)
	 * @param:@param yuanPATH   
	 * @return:void  
	 * @author:Zoutao
	 * @date:2018-6-23
	 * @version:V1.0
	 */
	
	/*本地测试专用--zoutao*/
	 public static void main(String[] args) {
		ConverVideoTest c = new ConverVideoTest();
		String yuanPATH = "D:/testfile/video/短avi测试.avi";  //本地源视频
        c.run(yuanPATH);
	}
 
	//web调用
    public void run(String yuanPATH) {
        try {
            // 转码和截图功能开始
        	
            //String filePath = "D:/testfile/video/rmTest.rm";  //本地源视频测试
        	
        	String filePath = yuanPATH;				//web传入的源视频
        	System.out.println("ConverVideoTest说:传入工具类的源视频为:"+filePath);
        	
            VideoUtils zout = new VideoUtils(filePath);  //传入path
            String targetExtension = ".mp4";  				//设置转换的格式
            boolean isDelSourseFile = true;
            
            //删除源文件
            boolean beginConver = zout.beginConver(targetExtension,isDelSourseFile);
            System.out.println(beginConver);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

