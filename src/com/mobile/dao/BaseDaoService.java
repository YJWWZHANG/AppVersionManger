package com.mobile.dao;

import java.util.List;
import java.util.Map;



public interface BaseDaoService<E> {
	/**
	 * 无条件查询 返回 全量 数据 无排序查询
	 */
	public  List<E> listAll(); 
	/**
	 * 按照 属性值 升序 查询  
	 * @param map
	 * @return
	 */
	public List<E> listAllAsc(Map map);
	/**
	 * 按照 属性值 降序 查询
	 * @param map
	 * @return
	 */
	public List<E> listAllDesc(Map map); 
	/**
	 * 条件查询返回 多个值
	 * @param map
	 * @return
	 */
	List<E> selectMultiple(Map map);
	/**
	 * 条件查询 返回 一个 值 
	 * @param map
	 * @return
	 */
	public E selectOne(Map map);
	/**
	 * 插入 
	 * @param object
	 */
	public void add(E object);
	/**
	 * 更新
	 * @param object
	 */
	public void update(E object);
	
	/**
	 * 更新 对象 
	 * @param object
	 */
	public void updateObject(Map map);
	/**
	 * 删除 
	 * @param map
	 */
	public void delete(Map map);
	/**
	 * 分页显示接口 
	 * @param object
	 * @return
	 */
	public List<E> listPageLog(E object);
}
