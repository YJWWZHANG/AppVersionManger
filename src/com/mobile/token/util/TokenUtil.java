package com.mobile.token.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;

import com.mobile.model.DataModel;
import com.mobile.model.ResultModel;
import com.mobile.token.entity.Token;
import com.mobile.token.service.ServiceOtherDate;
import com.mobile.util.IDGenerator;
import com.mobile.util.MobileUtil;
import com.mobile.util.Propertie;
import com.mobile.util.ResultCodeUtile;

public class TokenUtil {
	/**
	 * 实例化口令对象
	 * 
	 * @author fengjunming_t
	 * @param token
	 */
	public static Token getUserByToken(String token) {
		ServiceOtherDate tokenService = new ServiceOtherDate();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tokenid", token);
		map.put("beginvalidtime", new Date());
		List<Token> list = getUserByTokenList(map);
		Token mt = new Token();
		if (list != null && list.size() > 0) {// 判断当前的tokey值是否为空 2017年
			mt = list.get(0);
		}
		return mt;
	}

	/**
	 * 实例化口令对象
	 * 
	 * @author fengjunming_t
	 * @param token
	 */
	private static List<Token> getUserByTokenList(Map<String, Object> map) {
		ServiceOtherDate s = new ServiceOtherDate();
		List<Token> list = s.initGetTokenUser(map);
		
		return list;
	}
   public  static Map<String, Object> getTokenMap(String token){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tokenid", token);
		return map;
   }
   
	public static ResultModel getTokenResultModel(Map<String, Object> map) {
		ResultModel rm = new ResultModel();
		try {
			List<Token> list = getUserByTokenList(map);
			System.out.println("token 大小 "+list.size());
			if (null != list && list.size() > 0) {
				Token token = (Token) list.get(0);
				// 账号锁定
				if ("1".equals(token.getIslock())) {
					rm.setStatus(ResultCodeUtile.FAILURE);
					rm.setMsg("令牌被锁定!");
					rm.setErrcode(ResultCodeUtile.TOKENLOCKED);
				}
				// 炸弹消息
				if ("1".equals(token.getIsbomb())) {
					rm.setStatus(ResultCodeUtile.FAILURE);
					rm.setMsg("炸弹消息!");
					rm.setErrcode(ResultCodeUtile.TOKENBOMB);
				}
			} else {
				rm.setStatus(ResultCodeUtile.FAILURE);
				rm.setMsg("令牌过期!");
				rm.setErrcode(ResultCodeUtile.TOKENXPIRED);
			}

		} catch (Exception e) {
			e.printStackTrace();
			rm.setStatus(ResultCodeUtile.FAILURE);
			rm.setMsg("获取令牌失败!");
			rm.setErrcode(ResultCodeUtile.TOKENERR);
		}
		return rm;
	}
	/**
	 * 登陆接口 参数 获取 并分装 
	 * @param deviceType
	 * @param OperType
	 * @param username
	 * @param password
	 * @param clientVersion
	 * @param device
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getLoginTokenObject(String username, String password,String tokenId, HttpServletRequest request) {
		Map<String, Object> mapTemp = new HashMap<String, Object>();
		mapTemp.put("device", username);
		mapTemp.put("username", username);
		mapTemp.put("validtime", new Timestamp(new Date().getTime()+3*24*60*60*1000));//提前三天 就失效  防止 token过期 在 导致 应用 不能使用
		mapTemp.put("tokenid",tokenId);
		return mapTemp;
	}
	
	/**
	 * 首次登陆 制作 口令 对象 并分装 为对象  
	 * @return
	 */
	public static ResultModel getTokenFirstResultModel(String deviceType,
			String OperType, String username, String password,
			String clientVersion, String device, HttpServletRequest request,List<Token> tokenList){
		
		return null;
	}
	/**
	 * 不是 第一次 登陆 制作 口令 对象 并分装 为对象  
	 * @return
	 */
	public static ResultModel getTokenManyResultModel(String deviceType,
			String OperType, String username, String password,
			String clientVersion, String device, HttpServletRequest request,List<Token> tokenList){
		
		return null;
	}
	
	
	/**
	 * 不是 第一次 登陆 制作 口令 对象 并分装 为对象  
	 * @return
	 */
	public static Token getTokenObject( String username, String password
			, String device){
		Token token=new Token();
		token.setUsername(username);
		token.setTokenid(IDGenerator.RandomString(32));
		token.setPassword(password);
		token.setValidtime(MobileUtil.getDateAfter(new Date(), Propertie.getTokenVaditeTime()));
		token.setUpdatetime(new Date());
		token.setDevice(device);
		return token;
	}

}
