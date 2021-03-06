/**
 * 
 */
package org.applesline.forum.model;

import java.util.Date;

import org.applesline.forum.base.BaseBean;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月2日
 */
@Table(name = "t_article")
public class Article extends BaseBean  {

	private static final long serialVersionUID = 4392483015721935723L;
	
	// 主键ID（文章唯一ID）
	private long id;
	// 文章主题
	// 文章标题
	private String title;
	// 文章内容
	private String content;
	private int articleTheme;
	// 创建人
	private long userId;
	
	private int commentsNum;
	private int supportNum;
	private int viewNum;
	private int articleType;
	// 创建时间
	private Date createTime;
	private Date updateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getArticleTheme() {
		return articleTheme;
	}
	public void setArticleTheme(int articleTheme) {
		this.articleTheme = articleTheme;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getCommentsNum() {
		return commentsNum;
	}
	public void setCommentsNum(int commentsNum) {
		this.commentsNum = commentsNum;
	}
	public int getSupportNum() {
		return supportNum;
	}
	public void setSupportNum(int supportNum) {
		this.supportNum = supportNum;
	}
	public int getViewNum() {
		return viewNum;
	}
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	public int getArticleType() {
		return articleType;
	}
	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
