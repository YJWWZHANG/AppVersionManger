package com.mobile.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DataModel {
	/**
	 * 分页的list
	 */
	public static final String PAGELIST = "pageList";

	/**
	 * 不分页的list
	 */
	public static final String LIST = "list";

	private String alias;
	private String dataType;
	private Object dataObject;
	

	private Object newDataObject;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Object getDataObject() {
		return dataObject;
	}

	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Object getNewDataObject() {
		return newDataObject;
	}

	public void setNewDataObject(Object newDataObject) {
		this.newDataObject = newDataObject;
	}

	
	

}
