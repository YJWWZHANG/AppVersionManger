package com.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manager.entity.Menu;

public interface MenuService {
	List<Menu> listAllMenu();
	List<Menu> listAllParentMenu();
	List<Menu> listSubMenuByParentId(Integer parentId);
	Menu getMenuById(Integer menuId);
	void saveMenu(Menu menu);
	void deleteMenuById(Integer menuId);
	List<Menu> listAllSubMenu();
}
