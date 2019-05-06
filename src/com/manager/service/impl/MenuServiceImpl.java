package com.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manager.entity.Menu;
import com.manager.mapper.MenuMapper;
import com.manager.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	@Resource
	 MenuMapper menuMapper;
	
	public void deleteMenuById(Integer menuId) {
		// TODO Auto-generated method stub
		menuMapper.deleteMenuById(menuId);
	}

	public Menu getMenuById(Integer menuId) {
		// TODO Auto-generated method stub
		return menuMapper.getMenuById(menuId);
	}

	public List<Menu> listAllParentMenu() {
		// TODO Auto-generated method stub
		return menuMapper.listAllParentMenu();
	}

	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		if(menu.getMenuId()!=null && menu.getMenuId().intValue()>0){
			menuMapper.updateMenu(menu);
		}else{
			menuMapper.insertMenu(menu);
		}
	}

	public List<Menu> listSubMenuByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		return menuMapper.listSubMenuByParentId(parentId);
	}
	
	public List<Menu> listAllMenu() {
		// TODO Auto-generated method stub
		List<Menu> rl = this.listAllParentMenu();
		for(Menu menu : rl){
			List<Menu> subList = this.listSubMenuByParentId(menu.getMenuId());
			menu.setSubMenu(subList);
		}
		return rl;
	}

	public List<Menu> listAllSubMenu(){
		return menuMapper.listAllSubMenu();
	}
	
//	public MenuMapper getMenuMapper() {
//		return menuMapper;
//	}
//
//	public void setMenuMapper(MenuMapper menuMapper) {
//		this.menuMapper = menuMapper;
//	}

}
