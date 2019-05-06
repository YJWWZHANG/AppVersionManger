package com.manager.service;

import java.util.List;

import com.manager.entity.Role;


public interface RoleService {
	List<Role> listAllRoles();
	Role getRoleById(int roleId);
	boolean insertRole(Role role);
	boolean updateRoleBaseInfo(Role role);
	void deleteRoleById(int roleId);
	void updateRoleRights(Role role);
}
