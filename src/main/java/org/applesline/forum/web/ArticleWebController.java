package org.applesline.forum.web;


import org.applesline.forum.util.HttpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liuyaping on 2018/3/25
 */
@Controller
@RequestMapping("/web")
public class ArticleWebController {

    @RequestMapping("/articles")
    public ModelAndView index() throws Exception {
        ModelAndView view = new ModelAndView("index");
        view.addObject("articles", HttpUtils.getToJson(UrlsEnum.Article_list.url+"/1/10"));
        return view;
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("demo");
        return view;
    }

}
