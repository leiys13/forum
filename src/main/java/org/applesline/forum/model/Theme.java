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
@Table(name="t_theme")
public class Theme {

	private Integer id;
	private String themeName;
	private Integer seqNum;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public Integer getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}
	
}
