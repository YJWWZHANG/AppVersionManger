package com.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manager.entity.Info;
import com.manager.entity.Page;
import com.manager.mapper.InfoMapper;
import com.manager.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService{
	 @Resource
	 InfoMapper infoMapper;
	
	public List<Info> listPageInfo(Page page) {
		// TODO Auto-generated method stub
		return infoMapper.listPageInfo(page);
	}

//	public InfoMapper getInfoMapper() {
//		return infoMapper;
//	}
//
//	public void setInfoMapper(InfoMapper infoMapper) {
//		this.infoMapper = infoMapper;
//	}
}
