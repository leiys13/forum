/**
 * 
 */
package org.applesline.forum.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具。
 * 
 * @author liuyaping
 *
 * 创建时间：2018年3月7日
 */
public class Pagination<T> {

	private int firstPage = 1;
	private int prePage;
	private int currentPage;
	private int nextPage;
	private int lastPage;
	private int pageSize = 10;
	private int total = 0;
	private int totalPage;
	private List<T> datas;
	
	public static <T> Pagination<T> create(Class<T> t) {
		return new Pagination<T>();
	}
	/**
	 * 默认每页10条数据。
	 */
	private Pagination() {
		datas = new ArrayList<T>();
		total = 0;
	}
	
	public Pagination<T> init() {
		totalPage = total % pageSize == 0? total/pageSize : total/pageSize + 1;
		if(currentPage > totalPage) 
			currentPage = totalPage;
		if(total <= 0) {
			prePage = 1;
			nextPage = 1;
			lastPage = 1;
			totalPage = 1;
		} else {
			if(currentPage <= 1 && totalPage <= 1) {
				prePage = 1;
				nextPage = 1;
				lastPage = 1;
				totalPage = 1;
			} else if(currentPage <= 1 && totalPage > 1) {
				prePage = 1;
				nextPage = currentPage + 1;
				lastPage = totalPage;
			} else if(currentPage > 1 && totalPage > 1) {
				prePage = currentPage - 1;
				if(currentPage < totalPage) {
					nextPage = currentPage + 1;;
				} else {
					nextPage = totalPage;
				}
				lastPage = totalPage;
			}
		}
		return this;
	}
	
	public int getPrePage() {
		return prePage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public Pagination<T> setCurrentPage(int currentPage) {
		this.currentPage = currentPage <= 0 ? 1 : currentPage;
		return this;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public Pagination<T> setPageSize(int pageSize) {
		this.pageSize = pageSize <= 0 ? 10 : pageSize;
		return this;
	}
	public int getTotalPage() {
		return totalPage;
	}
	
	public int getTotal() {
		return total;
	}

	public Pagination<T> setTotal(int total) {
		this.total = total <= 0 ? 0 : total;
		return this;
	}

	public List<T> getDatas() {
		return datas;
	}
	public Pagination<T> setDatas(List<T> datas) {
		this.datas = datas == null ? new ArrayList<T>() : datas;
		return this;
	}
	
	public int getFirstPage() {
		return firstPage;
	}
	@Override
	public String toString() {
		return "Pagination [firstPage=" + firstPage + ", prePage=" + prePage + ", currentPage=" + currentPage
				+ ", nextPage=" + nextPage + ", lastPage=" + lastPage + ", pageSize=" + pageSize + ", total=" + total
				+ ", totalPage=" + totalPage + ", datas=" + datas + "]";
	}
	
}
