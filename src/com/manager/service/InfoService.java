package com.manager.service;

import java.util.List;

import com.manager.entity.Info;
import com.manager.entity.Page;


public interface InfoService {
	List<Info> listPageInfo(Page page);
}
