/**
 * 
 */
package org.applesline.forum.controller;

import java.util.HashMap;
import java.util.Map;

import org.applesline.forum.base.Response;
import org.applesline.forum.model.Article;
import org.applesline.forum.service.ArticleService;
import org.applesline.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public Response home() {
		return Response.SUCCESS.data("this is a test created by liuyaping");
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
	@ResponseBody
	public Response getArticle(Long id) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("article",  articleService.getArticle(id));
		result.put("comments", commentService.list(id));
		return Response.SUCCESS.data(result);
	}
	
	@RequestMapping("/listArticle")
	@ResponseBody
	public Response listArticle() {
		return Response.SUCCESS.data(articleService.listArticle());
	}
	
}
