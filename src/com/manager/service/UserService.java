package com.manager.service;

import java.util.List;

import com.manager.entity.User;


public interface UserService {
	User getUserById(Integer userId);
	
	boolean insertUser(User user);
	
	void updateUser(User user);
	
	User getUserByNameAndPwd(String username,String password);
	User getUserByNameAndUser(String username);
	
	void updateUserBaseInfo(User user);
	
	void updateUserRights(User user);
	
	void deleteUser(int userId);
	
	List<User> listPageUser(User user);
	
	void updateLastLogin(User user);
	
	User getUserAndRoleById(Integer userId);
	
	List<User> listAllUser();
}
