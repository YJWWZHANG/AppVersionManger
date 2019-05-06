package com.manager.util;

import com.manager.service.MenuService;
import com.manager.service.RoleService;
import com.manager.service.UserService;



/**
 * @author Administrator
 * 获取Spring容器中的service bean
 */
public final class ServiceHelper {
	
	public static Object getService(String serviceName){
		//WebApplicationContextUtils.
		System.out.println("--------start-------------------------");
		System.out.println(Const.WEB_APP_CONTEXT);
		System.out.println("----------end-----------------------");

		return Const.WEB_APP_CONTEXT.getBean(serviceName);
	}
	
	public static UserService getUserService(){
		return (UserService) getService("userService");
	}
	
	public static RoleService getRoleService(){
		return (RoleService) getService("roleService");
	}
	
	public static MenuService getMenuService(){
		return (MenuService) getService("menuService");
	}
}
