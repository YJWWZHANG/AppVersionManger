package com.manager.mapper;

import java.util.List;

import com.manager.entity.Role;


public interface RoleMapper {
	List<Role> listAllRoles();
	Role getRoleById(int roleId);
	void insertRole(Role role);
	void updateRoleBaseInfo(Role role);
	void deleteRoleById(int roleId);
	int getCountByName(Role role);
	void updateRoleRights(Role role);
}
