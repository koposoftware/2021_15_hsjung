package com.javamodeling.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultPojoList extends Pagination {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2805477010699519012L;

	private Pagination pagination = null;
	
	protected List<?> list = null;

	protected Set<?> set = null;

	protected Map<?, ?> map = null;
	
	protected Object value = null;
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Map<?, ?> getMap() {
		return map;
	}

	public void setMap(Map<?, ?> map) {
		this.map = map;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Set<?> getSet() {
		return set;
	}

	public void setSet(Set<?> set) {
		this.set = set;
	}

}
