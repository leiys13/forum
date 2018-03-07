/**
 * 
 */
package org.applesline.forum.util;

import java.security.MessageDigest;

import javax.servlet.http.Cookie;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月4日
 */
public class Util {
	
	private static final String salt = "@!)*_2018";

	public static String MD5(String s) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        s += salt;
	        byte[] bytes = md.digest(s.getBytes("utf-8"));
	        return toHex(bytes);
	    }
	    catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	private static String toHex(byte[] bytes) {

	    final char[] hexChars = "0123456789ABCDEF".toCharArray();
	    StringBuilder ret = new StringBuilder(bytes.length * 2);
	    for (int i=0; i<bytes.length; i++) {
	        ret.append(hexChars[(bytes[i] >> 4) & 0x0f]);
	        ret.append(hexChars[bytes[i] & 0x0f]);
	    }
	    return ret.toString();
	}
	
	public static String getSessionId(Cookie[] cookies) {
		for(Cookie cookie : cookies) {
			if("JSESSIONID".equalsIgnoreCase(cookie.getName())) {
				return cookie.getValue();
			}
		}
		return null;
	}
	
}
