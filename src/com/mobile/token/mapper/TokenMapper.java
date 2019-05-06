package com.mobile.token.mapper;

import java.util.List;
import java.util.Map;

import com.mobile.dao.BaseDaoService;
import com.mobile.token.entity.Token;

public interface TokenMapper extends BaseDaoService<Token> {

/**
 * 查询 所有用户 最后 一次登陆的 用户 信息 返回 token对象 
 * @return
 */
  public Token  selectLastUseTime(Map map);
 
}
