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
@Table(name="t_privilege")
public class Privilege {

	private Integer id;
	private String privilegeName;
	private String privilegeKey;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public String getPrivilegeKey() {
		return privilegeKey;
	}
	public void setPrivilegeKey(String privilegeKey) {
		this.privilegeKey = privilegeKey;
	}
	
}
