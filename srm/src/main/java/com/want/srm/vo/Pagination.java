
package com.want.srm.vo;

import java.util.List;

/**
 * @description Oracle分页模型
 * @author 00294476
 * @version V1.0.0
 */
public class Pagination<T> {

	// 请求部分
	private Long pageNum;

	private Long pageSize;

	// 分页条件
	private Long endRow;

	private Long beginRow;

	private Object parameter;// 封装业务数据，可拓展性强

	// 查询结果
	private List<T> resultList;// 从数据库查询后的结果列表

	private long totalCount;// 从数据库查询后的总记录

	private long totalPage;// 可以计算总页数,给页面的分页条用

	// 计算和返回页码号
	private long begin;

	private long end;

	public Long getPageNum() {
		return pageNum;
	}

	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getEndRow() {
		return endRow;
	}

	public void setEndRow(Long endRow) {
		this.endRow = endRow;
	}

	public Long getBeginRow() {
		return beginRow;
	}

	public void setBeginRow(Long beginRow) {
		this.beginRow = beginRow;
	}

	public Object getParameter() {
		return parameter;
	}

	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount, long pageNumSize) {
		// 赋值的时候，直接计算总页码数
		this.totalPage = (totalCount + pageSize - 1) / pageSize;

		// 计算显示的起始页码（根据当前页码计算）
		begin = pageNum - pageNumSize / 2;
		if (begin < 1) {// 页码修复
			begin = 1;
		}
		// 计算显示的结束页码（根据开始页码计算）
		end = begin + pageNumSize - 1;
		if (end > totalPage) {// 页码修复
			end = totalPage;
		}
		// 起始页面重新计算（根据结束页码计算）
		begin = end - pageNumSize - 1;
		if (begin < 1) {
			begin = 1;
		}
		this.totalCount = totalCount;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getBegin() {
		return begin;
	}

	public void setBegin(long begin) {
		this.begin = begin;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

}
