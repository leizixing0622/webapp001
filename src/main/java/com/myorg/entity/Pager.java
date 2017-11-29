package com.myorg.entity;

import java.util.List;

public class Pager<T> {

	private List<T> datas;// 每页显示的数据
	private int pageOffset;// 每页显示的起始条的索引
	private int pageSize;// 每页显示的条数
	private long totalRecord;// 总记录数
	private int currPageNumber;// 当前页数
	private int totalPageNumber;// 总页数

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getCurrPageNumber() {
		return currPageNumber;
	}

	public void setCurrPageNumber(int currPageNumber) {
		this.currPageNumber = currPageNumber;
	}

	public int getTotalPageNumber() {
		return totalPageNumber;
	}

	public void setTotalPageNumber(int totalPageNumber) {
		this.totalPageNumber = totalPageNumber;
	}

}
