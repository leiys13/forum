/**
 * 
 */
package org.applesline.forum.common;

import java.util.ArrayList;
import java.util.List;

import org.applesline.forum.model.User;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月7日
 */
public class PaginationTest {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		List<User> datas = new ArrayList<User>();
		Pagination<User> pagedData = Pagination.create(User.class).setDatas(datas).setTotal(221).setPageSize(2).setCurrentPage(-1).init();
		System.out.println(pagedData);
	}
}
