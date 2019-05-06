package com.mobile.appversion.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mobile.appversion.entity.Version;
import com.mobile.appversion.mapper.VersionMapper;
import com.mobile.appversion.util.AppVersionPushUtil;
import com.mobile.model.ResultModelVersion;
import com.mobile.util.ResultCodeUtile;

@Service
public class VersionService {
	@Resource
	VersionMapper versionMapper;
	
	public ResultModelVersion updateVersionNumberServiceInterface(
			HttpServletRequest request, String version,String appKey) {
		
		ResultModelVersion rm = new ResultModelVersion();
		//动作名称
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		String url =basePath +request.getRequestURI()+"?"+request.getQueryString();
		Map<String, Object>  versionParam=new HashMap<String, Object>();
		versionParam.put("appKey",appKey);//添加查询条件
		versionParam.put("state","true");//添加查询条件
		try{
			Version versionBeans=versionMapper.selectOne(versionParam);
			if(versionBeans!=null){
				String  oldVersion=versionBeans.getVersion();
				 int a=AppVersionPushUtil.compareVersion(version, oldVersion);//版本号对比
				if(a==0){//版本号相等不需要更新版本
					rm.setUpdate("No");
				}else if(a>0){//当前版本大于手机中的版本号，那么就不升级
					rm.setUpdate("No");
				}else if(a<0){//当前版本低于数据库中的版本 ，需要升级提示
					rm.setApk_url(versionBeans.getAppUrl());
					rm.setApk_file_url(versionBeans.getUpdatePackagePath());
					rm.setUpdate("Yes");
					rm.setUpdate_log(versionBeans.getUpdateLog());
					rm.setNew_version(versionBeans.getVersion());
					rm.setTarget_size(versionBeans.getTargetSize());
					rm.setConstraint(AppVersionPushUtil.getConstraintValue(versionBeans.getConstraints()));//新增 约束 constraint
				}
			}else{//没有查到最新版本 返回不需要更新标识
				rm.setUpdate("No");
			}
		}catch (Exception e) {
			e.printStackTrace();
			rm.setUpdate("No");
			rm.setStatus(ResultCodeUtile.ERROR);
		}
		//日志记录
		
		return rm;
	}
	
	/**
	 * 查询 版本 查询 所有数据
	 * @return
	 */
	public List<Version> getListALL(){
		return versionMapper.listAll();
	}
	
	/**
	 * 根据appKye值得到 对象
	 * @return
	 */
	public Version getVersionObject(String appKey){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("appKey", appKey);
		return versionMapper.selectOne(map);
	}
	/**
	 * 更新  表单数据 
	 * @param version
	 * @return
	 */
	public int getUpdateVersion(Version version){
		try{
			version.setUpdateTime(new Timestamp(new Date().getTime()));
			versionMapper.update(version);
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
			
		}
	}
	
	/**
	 * 文件上传 更新 数据库中的记录 
	 * @param appKey
	 * @param updatePackagePath
	 * @return
	 */
	public int updateUpploadFile(String appKey,String updatePackagePath,String targetSize){
		try{
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("updateTime",new Timestamp(new Date().getTime()));
			map.put("appKey", appKey);
			map.put("targetSize", targetSize);
			map.put("updatePackagePath",updatePackagePath);
			versionMapper.updateObject(map);
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * app 下载页面 获取 版本信息下载地址 
	 * @author fengjunming_t 2017年6月2日 
	 * @return
	 */
	public Map<String,Object> getAppVersionInfo(Map<String,Object> versionObject){
		
		Map<String,Object> maps=new HashMap<String,Object>();
		maps.put("android",AppVersionPushUtil.ANDROID);
		maps.put("ios",AppVersionPushUtil.IOS);
		List<Version> versionList=versionMapper.getVersionInfo(maps);
		for(Version ver:versionList){
			if(ver.getAppKey().equals(AppVersionPushUtil.ANDROID)){
				versionObject.put("android", ver);
			}else if(ver.getAppKey().equals(AppVersionPushUtil.IOS)){
				versionObject.put("ios", ver);
			}
		}
		return versionObject;
	}
}
