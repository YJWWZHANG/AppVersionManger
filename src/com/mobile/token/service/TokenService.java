package com.mobile.token.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mobile.model.ResultModel;
import com.mobile.token.entity.Token;
import com.mobile.token.mapper.TokenMapper;

@Service
public class TokenService {
	@Resource
	TokenMapper tokenMapper;

	/**
	 * 登陆 通过 口令值 获取到 当前用户的token 值 
	 * @author fengjunming_t
	 * @param map
	 * @return
	 */
	public List<Token> getLoginToken(Map<String,Object> map){
		return tokenMapper.selectMultiple(map);
	}
	
	/**
	 * 登陆 tokenid 得到 token 
	 * @author fengjunming_t
	 * @param map
	 * @return
	 */
	public Token getToken(String tokenid){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tokenid", tokenid);
		return tokenMapper.selectOne(map);
	}
	
	/**
	 * 登陆 通过 口令值 获取到 当前用户的token 值 
	 * @author fengjunming_t
	 * @param map
	 * @return
	 */
	public void creatToken(Token token){
		 tokenMapper.add(token);
	}
	
	
	/**
	 * 登陆 通过 口令值 获取到 当前用户的token 值 
	 * @author fengjunming_t
	 * @param map
	 * @return
	 */
	public void updateTokenObject(String tokenid,String password){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("password", "password");
		map.put("tokenid", tokenid);
		tokenMapper.updateObject(map);
	}
	
	/**
	 * 删除  token 口令 
	 * @author fengjunming_t
	 * @return
	 */
	public void deleteTokenId(String tokenid){
		Map<String,Object> maps=new HashMap<String,Object>();
		maps.put("tokenid", tokenid);
		tokenMapper.delete(maps);//删除口令 
	}
	
	/**
	 * 查询用户最后一次登陆 信息
	 * @param username
	 * @return
	 */
	public Token getUserLastUseTime(String username){
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("username", username);
		return tokenMapper.selectLastUseTime(hashMap);
	}
	
}
