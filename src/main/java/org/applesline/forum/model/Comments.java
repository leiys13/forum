/**
 * 
 */
package org.applesline.forum.model;

import java.util.Date;

import org.beetl.sql.core.annotatoin.Table;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月6日
 */
@Table(name="t_comments")
public class Comments {

	private Integer id;
	private long articleId;
	private Integer userId;
	private String content;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public long getArticleId() {
		return articleId;
	}
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
