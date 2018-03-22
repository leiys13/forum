/**
 * 
 */
package org.applesline.forum.model;

import java.util.Date;

import org.applesline.forum.base.BaseBean;
import org.applesline.forum.common.Consts;
import org.beetl.sql.core.annotatoin.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月4日
 */
@Table(name=Consts.DataBase.TABLE_T_USER)
public class User extends BaseBean {

	private static final long serialVersionUID = 8579878213510739287L;
	
	private long id;	// ID
	private String userName;	// 用户名
	private String nickName;	// 昵称
	private String email;		// 邮箱
	private long mobile = -1;	// 手机号
	@JsonIgnore
	private String password;	// 密码
	private int gender = -1;	// 性别（-1：未知；1：男；0：女）
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date birthday;		// 生日
	private String profilePic;	// 头像url地址
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;	// 注册时间
	private int groupId = -1;	// 所属用户组ID
	
	/*
	 * getter & setter
	 */
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
