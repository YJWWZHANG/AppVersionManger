package com.mobile.appversion.mapper;


import java.util.List;
import java.util.Map;

import com.mobile.appversion.entity.Version;
import com.mobile.dao.BaseDaoService;
/**
 * 连接数据库 实例类
 * @author fengjunming_t
 *
 */
public interface VersionMapper extends BaseDaoService<Version> {
	/**
	 * 查询 版本 下载地址 
	 * @param map
	 * @return
	 */
	List<Version> getVersionInfo(Map<String,Object> map);

}
