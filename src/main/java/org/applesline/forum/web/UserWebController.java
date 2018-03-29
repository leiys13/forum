package org.applesline.forum.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @date 2018年3月29日
 * @author lei.ys
 * @addr company
 * @desc
 */
@Controller
@RequestMapping("/user")
public class UserWebController {
	
	@RequestMapping("/toLogin")
	public ModelAndView login() throws Exception {
		ModelAndView view = new ModelAndView("login");
		return view;
	}

}
