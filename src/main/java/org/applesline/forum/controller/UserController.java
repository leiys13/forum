/**
 * 
 */
package org.applesline.forum.controller;

import javax.servlet.http.HttpServletRequest;

import org.applesline.forum.base.BaseController;
import org.applesline.forum.base.Response;
import org.applesline.forum.base.Status;
import org.applesline.forum.common.Consts;
import org.applesline.forum.model.User;
import org.applesline.forum.service.UserService;
import org.applesline.forum.util.RegexUtil;
import org.applesline.forum.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月2日
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	private static final long serialVersionUID = 388893889134825959L;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 * @param loginName
	 * @param loginPwd
	 * @param request
	 * @return
	 */
	@RequestMapping("/check") 
	public Response checkUser(String loginName,String loginPwd,HttpServletRequest request) {
		if(null==loginName || null==loginPwd) {
			return Response.instance(Status.REQUEST_PARAM_ERROR, "用户名或密码不正确");
		}
		User loginUser = userService.checkLogin(loginName, Util.MD5(loginPwd));
		if(null!=loginUser) {
			super.getRequest().getSession().setAttribute(Consts.LOGIN_USER, loginUser);
		} else {
			return Response.instance(Status.REQUEST_NOT_EXIST_ERROR, "查询不到用户");
		}
		return Response.instance("登录成功", loginUser);
	}

	/**
	 * 用户注册
	 * @param userName	用户名
	 * @param password	密码
	 * @return
	 */
	@RequestMapping("/register") 
	public Response createUser(String userName,String password) {
		if(null==userName || null==password || !RegexUtil.match(Consts.Regex.USER_NAME, userName) 
				|| !RegexUtil.match(Consts.Regex.PASSWORD, password)) {
			return Response.instance(Status.REQUEST_PARAM_ERROR, "用户名或密码不正确");
		}
		if(userService.exist(userName)) {
			return Response.instance(Status.REQUEST_VALID_ERROR, "用户名已被注册");
		}
		User user = new User();
		user.setUserName(userName);
		user.setNickName(userName);
		user.setPassword(Util.MD5(password));
		try {
			userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.instance(Status.SYSTEM_ERROR, "新增用户出错");
		}
		return Response.instance("注册成功");
	}
	
	/**
	 * 用户注销
	 * @return
	 */
	@RequestMapping("/checkout")
	public Response logout() {
		super.getRequest().getSession().removeAttribute(Consts.LOGIN_USER);
		return Response.instance("注销成功");
	}
	
}
