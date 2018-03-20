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
	
	public static final Response SUCCESS = new Response(100,"成功");
	public static final Response FAILURE = new Response(800,"失败");
	
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
		this.code = SUCCESS_CODE;
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
	
	
	
	// 请求成功
	private static final int SUCCESS_CODE = 100;
	// 请求出错（通用）
	private static final int REQUEST_ERROR_CODE = 600;
	// 参数不正确（缺少必须参数或者参数值非法）
	private static final int REQUEST_PARAM_ERROR_CODE = 610;
	// 验证错误（参数为合法值，但是受系统限制，如用户名不能重复）
	private static final int REQUEST_VALID_ERROR_CODE = 620;
	// 无权限
	private static final int REQUEST_AUTH_ERROR_CODE = 630;
	// 请求不存在的
	private static final int REQUEST_NOT_EXIST_ERROR_CODE = 640;
	// 系统错误（通用）
	private static final int SYSTEM_ERROR_CODE = 800;
	// 系统处理时间过长
	private static final int SYSTEM_SLOW_ERROR_CODE = 810;
	// 通用提示
	private static final String SUCCESS_MESSAGE = "请求成功";
	private static final String REQUEST_ERROR_MESSAGE = "请求出错";
	private static final String SYSTEM_ERROR_MESSAGE = "系统错误";
	
	public void setCode(Status status) {
		switch(status) {
		case REQUEST_ERROR:
			this.code = REQUEST_ERROR_CODE; break;
		case REQUEST_PARAM_ERROR:
			this.code = REQUEST_PARAM_ERROR_CODE; break;
		case REQUEST_VALID_ERROR:
			this.code = REQUEST_VALID_ERROR_CODE; break;
		case REQUEST_AUTH_ERROR:
			this.code = REQUEST_AUTH_ERROR_CODE; break;
		case REQUEST_NOT_EXIST_ERROR:
			this.code = REQUEST_NOT_EXIST_ERROR_CODE; break;
		case SYSTEM_ERROR:
			this.code = SYSTEM_ERROR_CODE; break;
		case SYSTEM_SLOW_ERROR:
			this.code = SYSTEM_SLOW_ERROR_CODE; break;
		default:
			this.code = SUCCESS_CODE; break;
		}
	}
	
	public static Response instance(Status status, String message, Object data) {
		Response ins = new Response();
		ins.setCode(status);
		if(null==message) {
			int state = ins.code/100;
			if(1==state) {
				message = SUCCESS_MESSAGE;
			} else if(6==state) {
				message = REQUEST_ERROR_MESSAGE;
			} else {
				message = SYSTEM_ERROR_MESSAGE;
			}
		}
		ins.setMessage(message);
		ins.setData(data);
		return ins;
	}
	
	public static Response instance(Status status, String message) {
		return instance(status, message, null);
	}
	
	public static Response instance(String message, Object data) {
		return instance(Status.SUCCESS, message, data);
	}
	
	public static Response instance(Status status) {
		return instance(status, null, null);
	}
	
	public static Response instance(Object data) {
		return instance(Status.SUCCESS, null, data);
	}
	
	public static Response instance(String message) {
		return instance(Status.SUCCESS, message, null);
	}
	
	public static Response instance() {
		return new Response();
	}
	
}
