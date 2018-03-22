/**
 * 
 */
package org.applesline.forum.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.applesline.forum.base.Response;
import org.applesline.forum.base.Status;
import org.applesline.forum.common.Consts;
import org.applesline.forum.util.JsonUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月4日
 */
public class AuthInterceptor implements HandlerInterceptor {

	/* 
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(handler);
		Object obj = request.getSession().getAttribute(Consts.LOGIN_USER);
		if(obj == null) {
			if(request.getRequestURI().contains("/add")) {
				response.setContentType("application/json; charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().print(JsonUtil.writeJson(Response.instance(Status.REQUEST_NO_LOGIN_ERROR, "未登录")));
				return false;
			}
//			request.getRequestDispatcher("/user/login").forward(request, response);
			return true;
		}
		System.out.println(request.getRequestURI());
		if(request.getRequestURI().equals("/")) {
			request.getRequestDispatcher("/article/listArticle/1/20").forward(request, response);
		}
		return true;
	}

	/* 
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/* 
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
