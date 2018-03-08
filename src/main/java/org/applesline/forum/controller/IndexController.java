package org.applesline.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @desc
 */
@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "forward:/article/listArticle";
	}

}
