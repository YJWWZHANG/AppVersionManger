package com.manager.mapper;

import java.util.List;

import com.manager.entity.Info;
import com.manager.entity.Page;

public interface InfoMapper {
	List<Info> listPageInfo(Page page);
}
