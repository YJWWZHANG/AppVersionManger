package com.manager.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mobile.appversion.entity.Version;
import com.mobile.appversion.service.VersionService;
import com.mobile.util.FileUtil;
import com.mobile.util.Propertie;

@Controller
@RequestMapping(value="/appVersionManager")
public class AppVersionController {
	  public static Log logger=LogFactory.getLog(AppVersionController.class);

	@Resource
	VersionService versionService;
	
	/**
	 * 显示版本列表
	 * @param map
	 * @return
	 */
	@RequestMapping
	public String list(Model model,Map<String,Object> map){
		List<Version> listVersion=versionService.getListALL();
		model.addAttribute("listVersion", listVersion);
		return "appVersionUpdate";
	}
	
	
	/**
	 *编辑页面 
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editVersionInfo(Model model,Map<String,Object> map,@RequestParam String appKey){
		Version versions=versionService.getVersionObject(appKey);
		model.addAttribute("versions", versions);
		return "version_info";
	}
	
	
	/**
	 *修改版本 信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyVersionInfo(Model model,Version version){
		if(versionService.getUpdateVersion(version)!=0){//更新数据成功
			model.addAttribute("msg","success");
		}else{
			model.addAttribute("msg","failed");
		}
		return "save_result";
	}
	
	
	/**
	 * app文件上传编辑 页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String appFileUpload(Model model,@RequestParam("appKey")String appKey){
		model.addAttribute("appKey", appKey);
		return "app_file_uppload";
	}
	
	
	/**
	 * 文件 上传 接口 
	 * @param model
	 * @param request
	 * @param file
	 * @param appKey
	 * @return
	 */
	//单个 文件上传 文件 提交 接受 数据页面 
	@RequestMapping(value="/appFileUpload")
	public String getAppUploadFile(Model model,HttpServletRequest request,@RequestParam MultipartFile file ,@RequestParam String appKey){
		try {
			// 判断文件是否为空  
	        if (!file.isEmpty()) {  
	            try {  
	                // 文件保存路径  
	            	String appFilePath=Propertie.getFilePath()+Propertie.getAppDownloadFile()+"\\"+ file.getOriginalFilename();//得到 文件下载的根目录 
	            	FileUtil.createFolder(appFilePath, true);//路径不存在则创建 
	                logger.info("文件上传路径："+appFilePath);
	                // 转存文件  
	                file.transferTo(new File(appFilePath));  
	                String targetSize= new FileInputStream(new File(appFilePath)).available() / 1024 / 1024 +"M";//得到 上传文件的大小 
	                logger.info("targetSize："+targetSize);
	               String  updatePackagePath = request.getScheme() + "://"
			   			+ request.getServerName() + ":" + request.getServerPort()
			   			+ "/online/"+Propertie.getAppDownloadFile()+"/"+file.getOriginalFilename();//得到 文件下载 地址 
	               logger.info("updatePackagePath："+updatePackagePath);
	                versionService.updateUpploadFile(appKey,updatePackagePath, targetSize);
	                
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        } 
	        model.addAttribute("msg","success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg","failed");
		}
		return "save_result";
	}
	
	/**
	 *app 文件 单独下载页面地址 
	 * @param map
	 * @return
	 */
	@RequestMapping(value="download",method=RequestMethod.GET)
	public String appVersion(Map<String,Object> map){
		versionService.getAppVersionInfo(map);
		return "download";
	}
	
	
}
