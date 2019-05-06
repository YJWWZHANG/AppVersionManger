package com.manager.controller;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/app")
public class AppUploadController {
	
	//单个 文件上传 文件 提交 接受 数据页面 
	@RequestMapping(value="/UploadFile",method=RequestMethod.POST)
	public String getAppUploadFile(HttpServletRequest request,@RequestParam("file") MultipartFile file ){
		try {
			// 判断文件是否为空  
	        if (!file.isEmpty()) {  
	            try {  
	                // 文件保存路径  
	                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload\\"  
	                        + file.getOriginalFilename();  
	                System.out.println(filePath);
	                // 转存文件  
	                file.transferTo(new File(filePath));  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        } 
			System.out.println("文件接受 成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,String> map=new HashMap<String,String>();
		map.put("msg", "成功");
		request.setAttribute("msg", "成功");
		return "uploadSucess";//app/UploadFile.html
	}
	
	//单个 文件上传 页面 
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAppUpload(Model model){
		ModelAndView mv=new ModelAndView("apps",null);
		return mv;
	}
	
	
	//多个上传 页面 
	@RequestMapping(value="/allUpload",method=RequestMethod.GET)
	public ModelAndView getAllUpload(Model model){
		ModelAndView mv=new ModelAndView("filesUpload",null);
		return mv;
	}
	
	//多 个 文件上传 文件 提交 接受 数据页面 
	@RequestMapping(value="/AllUploadFile",method=RequestMethod.POST)
	public String getAppAllUploadFile(HttpServletRequest request,@RequestParam("files") MultipartFile[] file ){
		try {
			for(int i=0;i<file.length;i++){
			// 判断文件是否为空  
	        if (!file[i].isEmpty()) {  
		            try {  
		                // 文件保存路径  
		                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload\\"  
		                        + file[i].getOriginalFilename();  
		                System.out.println(filePath);
		                // 转存文件  
		                file[i].transferTo(new File(filePath));  
		            } catch (Exception e) {  
		                e.printStackTrace();  
		            }  
		        } 
				System.out.println("文件接受 成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer buf=new StringBuffer();
		String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
		ModelAndView mav = new ModelAndView("list");
		File uploadDest = new File(filePath);
		String[] fileNames = uploadDest.list();
		for (int i = 0; i < fileNames.length; i++) {
			System.out.println(fileNames[i]);
			buf.append(fileNames[i]+"\n");
		}
		request.setAttribute("msg", "成功"+buf.toString());
		return "uploadSucess";//app/UploadFile.html
	}
	
	/***
	 * 读取上传文件中得所有文件并返回
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request) {
		String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
		ModelAndView mav = new ModelAndView("list");
		File uploadDest = new File(filePath);
		String[] fileNames = uploadDest.list();
		for (int i = 0; i < fileNames.length; i++) {
			System.out.println(fileNames[i]);
		}
		return mav;
	}
	
}
