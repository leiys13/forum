package org.applesline.forum.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liuyaping on 2018/3/25
 */
@Controller
public class IndexWebController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("demo");
        return view;
    }

}
