package com.myspringboot.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//分页页码默认页码为1
	protected int page = 1;
	
	//分页每页数量默认为20条
	protected int size = 20;
	
	//排序列名称默认为id
	protected String sidx = "id";
	
	//排序方向
	private String sort;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
