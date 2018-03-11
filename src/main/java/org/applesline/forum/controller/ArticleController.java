/**
 * 
 */
package org.applesline.forum.controller;

import java.util.ArrayList;

import org.applesline.forum.base.Response;
import org.applesline.forum.model.Article;
import org.applesline.forum.service.ArticleService;
import org.applesline.forum.service.CommentService;
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
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView view = new ModelAndView("/home.btl");
		view.addObject("list",  new ArrayList());
		return view;
	}
	
	@RequestMapping("/addview")
	public ModelAndView addview() {
		ModelAndView view = new ModelAndView("/addArticle.btl");
		return view;
	}
	
	@RequestMapping("/delete") 
	@ResponseBody
	public Response delete(long id) {
		articleService.delete(id);
		return Response.SUCCESS.data("delete success！");
	}
	
	@RequestMapping("/test") 
	@ResponseBody
	public Response test() {
		return Response.FAILURE.data("this is a test for failure");
	}
	
	@RequestMapping("/add") 
	@ResponseBody
	public Response createArticle(String title,String subtitle,String content) {
		boolean exist = articleService.exist(title);
		if(exist) {
			return Response.FAILURE.data("already exist title " + title);
		}
		Article article = new Article();
		article.setArticleTheme(1);
		article.setContent(content);
//		article.setCreateTime(new Date());
		article.setImageUrl("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2531384262,3699915741&fm=27&gp=0.jpg");
		article.setTitle(title);
		articleService.addArticle(article);
		return Response.SUCCESS.data("{success:'haha'}");
	}
	
	@RequestMapping("/getArticle")
	public ModelAndView getArticle(Long id) {
		ModelAndView view = new ModelAndView("/viewArticle.btl");
		view.addObject("article",  articleService.getArticle(id));
		view.addObject("comments", commentService.list(id));
		view.addObject("articleId",id);
		return view;
	}
	
	@RequestMapping("/listArticle")
	@ResponseBody
	public ModelAndView listArticle() {
		ModelAndView view = new ModelAndView("/list.btl");
		view.addObject("list",  articleService.listArticle());
		view.addObject("themes",new String[]{"精华","财务"});
		return view;
	}
	
}
