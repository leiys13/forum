package org.applesline.forum.util;

import java.io.Serializable;

/**
 * @date 2018年3月21日
 * @author lei.ys
 * @addr company
 * @desc 字符串工具类
 */
public class StringUtil implements Serializable {

	private static final long serialVersionUID = -1036558989161952808L;
	
	public static boolean isEmpty(String string) {
		if(null==string || "".equals(string.trim())) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(String string) {
		return !isEmpty(string); 
	}
	
	private StringUtil() {
	}

}
