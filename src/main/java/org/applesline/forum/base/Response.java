/**
 * 
 */
package org.applesline.forum.base;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月3日
 */
public class Response implements Serializable {

	private static final long serialVersionUID = -1213217915842455544L;
	
	public static final Response SUCCESS = new Response(1000,"成功");
	public static final Response FAILURE = new Response(1100,"失败");
	
	private int code;
	private String message;
	private Object data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public Response() {
	}
	/**
	 * @param code
	 */
	public Response(int code) {
		this(code, null);
	}
	/**
	 * @param code
	 * @param message
	 */
	public Response(int code, String message) {
		this(code,message,null);
	}
	/**
	 * @param code
	 * @param message
	 * @param data
	 */
	public Response(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Response data(Object data) {
		Response response = new Response();
		BeanUtils.copyProperties(this, response);
		response.setData(data);
		return response;
	}
	
}
