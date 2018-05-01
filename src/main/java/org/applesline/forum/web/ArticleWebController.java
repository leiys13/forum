package org.applesline.forum.web;


import org.applesline.forum.util.HttpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liuyaping on 2018/3/25
 */
@Controller
@RequestMapping("/web/article")
public class ArticleWebController {

	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView view = new ModelAndView("article/list");
		view.addObject("articles", HttpUtils.getToJson(UrlsEnum.Article_list.url+"/1/10"));
		return view;
	}

	@RequestMapping("/detail")
	public ModelAndView detail(long id) throws Exception {
		ModelAndView view = new ModelAndView("article/detail");
		view.addObject("article", HttpUtils.getToJson(UrlsEnum.Article_detail.url+id));
		return view;
	}

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("demo");
        return view;
    }

}
