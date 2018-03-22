package org.applesline.forum.vo;

import java.util.Date;

import org.applesline.forum.base.BaseBean;
import org.applesline.forum.model.Comments;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @date 2018年3月22日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class CommentsList extends BaseBean {

	private static final long serialVersionUID = 2927798612490806142L;
	
	private long id;
	@JsonIgnore
	private long articleId;
	private long userId;
	private String userName;
	private String nickName;
	private String profilePic;
	private String content;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	public CommentsList() {
	}
	
	public CommentsList(Comments comment) {
		this.id = comment.getId();
		this.articleId = comment.getArticleId();
		this.content = comment.getContent();
		this.createTime = comment.getCreateTime();
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
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
