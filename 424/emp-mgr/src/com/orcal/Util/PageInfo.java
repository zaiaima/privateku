package com.orcal.Util;

import java.util.List;

public class PageInfo<V> {

	// 当前页
	private int crtPage;

	// 每页行数
	private int pageCnt;

	// 总记录数
	private int totalCnt;

	// 总页数
	private int totalPage;

	// 分页数据
	private List<V> pageData;

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

	public int getTotalPage() {
		this.totalPage = this.totalCnt / this.pageCnt;
		if (this.totalCnt % this.pageCnt > 0) {
			this.totalPage++;
		}
		return totalPage;
	}

	public List<V> getPageData() {
		return pageData;
	}

	public void setPageData(List<V> pageData) {
		this.pageData = pageData;
	}

	public PageInfo() {
		this.crtPage = 1;
		this.pageCnt = 10;
	}
}
