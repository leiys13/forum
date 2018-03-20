package org.applesline.forum.common;

import java.io.Serializable;

/**
 * @date 2018年3月20日
 * @author lei.ys
 * @addr company
 * @desc 常量定义类
 */
public class Consts implements Serializable {

	private static final long serialVersionUID = -4986116107872710746L;
	// 登录用户session保存key
	public static final String LOGIN_USER = "loginUser";
	
	/**
	 * 数据库表常量类
	 */
	public class DataBase {
		
		// 用户表
		public static final String TABLE_T_USER = "t_user";
		
	}
	
	/**
	 * 正则表达式常量类
	 */
	public class Regex {
		
		// 用户名的正则表达式（字母或者数字组成的2-20位字符）
		public static final String USER_NAME = "[0-9A-Za-z]{2,20}";
		// 密码的正则表达式（不包含中文的6-15位字符）
		public static final String PASSWORD = "^[^\\u4e00-\\u9fa5]{6,15}";
		
	}

}
