package com.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manager.entity.Role;
import com.manager.mapper.RoleMapper;
import com.manager.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	 RoleMapper roleMapper;
	
	public List<Role> listAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.listAllRoles();
	}

	public void deleteRoleById(int roleId) {
		// TODO Auto-generated method stub
		roleMapper.deleteRoleById(roleId);
	}

	public Role getRoleById(int roleId) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleById(roleId);
	}

	public boolean insertRole(Role role) {
		// TODO Auto-generated method stub
		if(roleMapper.getCountByName(role)>0)
			return false;
		else{
			roleMapper.insertRole(role);
			return true;
		}
	}

	public boolean updateRoleBaseInfo(Role role) {
		// TODO Auto-generated method stub
		if(roleMapper.getCountByName(role)>0)
			return false;
		else{
			roleMapper.updateRoleBaseInfo(role);
			return true;
		}
	}
	
	public void updateRoleRights(Role role) {
		// TODO Auto-generated method stub
		roleMapper.updateRoleRights(role);
	}

//	public RoleMapper getRoleMapper() {
//		return roleMapper;
//	}
//
//	public void setRoleMapper(RoleMapper roleMapper) {
//		this.roleMapper = roleMapper;
//	}

}
