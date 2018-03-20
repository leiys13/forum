package org.applesline.forum.util;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @date 2018年3月20日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class JsonUtil implements Serializable {
	
	private static final long serialVersionUID = 1933721767372906818L;
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * Object对象转为json字符串
	 * @param object
	 * @return
	 */
	public static String writeJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private JsonUtil() {
	}

}
