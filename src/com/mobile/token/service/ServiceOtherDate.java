package com.mobile.token.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import com.mobile.token.entity.Token;


/**
 * 加载静态常量参数 逻辑处理
 * 
 * @author fengjunming_t
 * 
 */
@Service
public class ServiceOtherDate {
	protected static Log logger = LogFactory.getLog(ServiceOtherDate.class);
	public  static JdbcTemplate jdbcTemplate;// 连接数据库 对象

	/**
	 * 数据库中获取静态常量参数
	 * 
	 * @author fengjunming_t
	 */
	public List<Token> initGetTokenUser(Map<String, Object> map) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(new Date());
		StringBuffer slqs = new StringBuffer("select * from  mobile_token k  where 1=1 ");// 查询 语句
		slqs.append(" and k.validtime >=  '" +dateString+"'");
		final List<Token> array = new ArrayList<Token>();
		if (map.get("tokenid") != null) {
			slqs.append(" and k.tokenid = ? ");
		}else{
			return array;
		}

		logger.info(slqs+"\n tokenid="+map.get("tokenid"));
		jdbcTemplate.query(slqs.toString(),new Object[]{map.get("tokenid")},new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Token route = new Token();
				route.setId(rs.getString(1));
				route.setUsername(rs.getString(2));
				route.setPassword(rs.getString(3));
				route.setTokenid(rs.getString(4));
				route.setValidtime(rs.getTimestamp(5));
				route.setIslock(rs.getInt(6));
				route.setIsbomb(rs.getInt(7));
				route.setUpdatetime(rs.getTime(8));
				route.setDevice(rs.getString(9));
				array.add(route);
			}
		});

		return array;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
