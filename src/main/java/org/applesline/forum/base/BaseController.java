package org.applesline.forum.base;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @date 2018年3月20日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class BaseController implements Serializable {

	private static final long serialVersionUID = 7315202231315469026L;
	
	public HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
		return attrs.getRequest();
	}
	
}
