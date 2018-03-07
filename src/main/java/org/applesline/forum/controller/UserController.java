/**
 * 
 */
package org.applesline.forum.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.applesline.forum.base.Response;
import org.applesline.forum.model.User;
import org.applesline.forum.service.UserService;
import org.applesline.forum.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月2日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login") 
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("/login.btl");
		return view;
	}
	
	@RequestMapping("/add") 
	@ResponseBody
	public Response createUser(String username,String password,String email) {
		boolean exist = userService.exist(username);
		if(exist) {
			return Response.FAILURE.data("already exist username " + username);
		}
		User user = new User();
		user.setUserName(username);
		user.setPassword(Util.MD5(password));
		user.setEmail(email);
		userService.addUser(user);
		return Response.SUCCESS.data("{success:'haha'}");
	}
	
	@RequestMapping("/check") 
	@ResponseBody
	public Response checkUser(String loginName,String loginPwd,HttpServletRequest request) {
		boolean exist = userService.checkLogin(loginName, Util.MD5(loginPwd));
		Map<String,String> result = new HashMap<String,String>();
		if(exist) {
			System.out.println("==>"+Util.getSessionId(request.getCookies()));
			System.out.println("===>"+loginName);
			result.put("status","1");
			request.getSession().putValue(Util.getSessionId(request.getCookies()), loginName);
		} else {
			result.put("status","0");
		}
		return Response.SUCCESS.data(result);
	}
	
	
}
