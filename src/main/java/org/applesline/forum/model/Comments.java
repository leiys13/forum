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

	private long id;
	private long articleId;
	private long userId;
	private String content;
	private Date createTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getArticleId() {
		return articleId;
	}
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
