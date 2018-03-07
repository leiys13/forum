/**
 * 
 */
package org.applesline.forum.model;

import org.beetl.sql.core.annotatoin.Table;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月6日
 */
@Table(name="t_user_group")
public class UserGroup {

	private Integer id;
	private String groupName;
	private String groupKey;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupKey() {
		return groupKey;
	}
	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}
	
}
