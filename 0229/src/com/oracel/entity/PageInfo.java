package com.oracel.entity;

import java.util.List;

public class PageInfo<T> {
//	当前页
	private int crtPage;
//	每页的行数
	private int pageCnt;
//	总行数
	private int totalCnt;
//	总页数
	private int totalPage;
//	分页数据
	private List<T> pageData;
	
	public int getCrtPage() {
		return crtPage;
	}
	public void setCrtPage(int crtPage) {
		this.crtPage = crtPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPage() {
		this.totalPage = this.totalCnt / this.pageCnt;
		if(this.totalCnt % this.pageCnt > 0){
			this.totalPage++;
		}
		return this.totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	public PageInfo(int crtPage, int pageCnt, int totalCnt, int totalPage, List<T> pageData) {
		super();
		this.crtPage = crtPage;
		this.pageCnt = pageCnt;
		this.totalCnt = totalCnt;
		this.totalPage = totalPage;
		this.pageData = pageData;
	}
	public PageInfo(){
		this.crtPage = 1;
		this.pageCnt = 10;
	}
	
	
}
