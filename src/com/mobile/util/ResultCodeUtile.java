package com.mobile.util;

/**
 * 全局 错误 码 
 * @author fengjunming_t
 *
 */
public class ResultCodeUtile {
	//token 令牌返回值
	public static String TIMESTAMPERR="40001";
	public static String CREATETOKENERR="40004";
	public static String TOKENERR="40005";//获取令牌失败
	public static String TOKENXPIRED="40006";//令牌过期
	public static String TOKENLOCKED="40007";//令牌锁定
	public static String TOKENBOMB="40008";//发送炸弹消息
	public static String TOKENNULL="40009";//令牌传入的值为空
	public static String LOGOUTERR="40010";//注销失败
	//用户认证 表 
	/**
	 * 用户名错误
	 */
	public static String RESULT_USERNAME_ERROR = "101";
	/**
	 * 密码错误
	 */
	public static String RESULT_PAASSWORD_ERROR ="102";
	/**
	 * 用户名和密码都错误
	 */
	public static String RESULT_USER_PWD_ERROR = "103";
	/**
	 * 接口异常 
	 */
	public static String RESULT_EXCEPTION_ERROR = "104";//
	
	
	/**
	 * 用户登陆成功
	 */
	public static String RESULT_SUCCEED = "100";//
    //其他认证类型 
	/**
	 * 所有 认证失败返此标识
	 */
	public static String RESULT_ALL_ERROR = "111";//所有 认证失败返此标识
	
	//认证成功和失败标识符号 、
	/**
	 * 错误标识 failure
	 */
	public static String FAILURE="failure";
	/**
	 * 错误标识 error
	 */
	public static String ERROR="error";
	/**
	 * 成功标识 success
	 */
	public static String SUCCESS="success";
	
	
	/**
	 * 注册用户已经存在  
	 */
	public static String RESULT_USER_EXISTS = "exists";//
	
	/**
	 * 用户没有注册 
	 */
	public static String RESULT_USER_NOT_EXISTS = "noExists";//
	
	/**
	 * 验证码 错误 
	 */
	public static String RESULT_VALIDATE_CODE_ERROR="verificationCodeError";
	
	/**
	 * 验证码 正确  
	 */
	public static String RESULT_VALIDATE_CODE_RIGHT="verificationCodeRight";
	
	/**
	 * 登陆模块标识 
	 */
	public static String LOGIN_MODEL="login";
	
	/**
	 * 注册模块   
	 */
	public static String REGISTERED_MODEL="registered";
	
	
	/**
	 * 退出模块   
	 */
	public static String LOGOUT_MODEL="logout";
	
	/**
	 * 修改密码模块
	 */
	public static String MODIFY_PWD_MODEL="modifyPwd";
	
	/**
	 * 信用卡 模块  
	 */
	public static String CARD_MODEL="card";
	
	
	/**
	 * 信用卡修改 模块  
	 */
	public static String MODIFY_CARD_MODEL="modifyCard";
	
	
	/**
	 * 短信 下发 模块  
	 */
	public static String SMS_SEND_MODEL="smsSend";
	
	
	/**
	 *  用户 头像 
	 */
	public static String USER_HEAD_IMAGE_MODEL="userHeadImage";
	
	/**
	 *  用户 昵称  
	 */
	public static String USER_NICK_MODEL="nick";
	
	
}
