/**
 * 
 */
package org.applesline.forum.controller;

import java.util.HashMap;
import java.util.Map;

import org.applesline.forum.base.BaseController;
import org.applesline.forum.base.Response;
import org.applesline.forum.base.Status;
import org.applesline.forum.common.Consts;
import org.applesline.forum.model.Article;
import org.applesline.forum.model.User;
import org.applesline.forum.service.ArticleService;
import org.applesline.forum.service.CommentService;
import org.applesline.forum.util.StringUtil;
import org.applesline.forum.vo.ArticleInfo;
import org.applesline.forum.vo.ArticleList;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月2日
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
	
	private static final long serialVersionUID = -6957645240208581310L;
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;

	@RequestMapping("/home")
	public Response home() {
		return Response.SUCCESS.data("this is a test created by liuyaping");
	}
	
	@RequestMapping("/delete") 
	public Response delete(long id) {
		articleService.delete(id);
		return Response.SUCCESS.data("delete success！");
	}
	
	@RequestMapping("/test") 
	public Response test() {
		return Response.FAILURE.data("this is a test for failure");
	}
	
	@RequestMapping("/add") 
	public Response createArticle(String title, String content) {
		if(StringUtil.isEmpty(title) || StringUtil.isEmpty(content)) {
			return Response.instance(Status.REQUEST_PARAM_ERROR, "标题和内容不能为空");
		}
		Article article = new Article();
		article.setArticleTheme(0);
		article.setTitle(title);
		article.setContent(content);
		User loginUser = (User) super.getRequest().getSession().getAttribute(Consts.LOGIN_USER);
		article.setUserId(loginUser.getId());
		try {
			articleService.addArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.instance(Status.SYSTEM_ERROR);
		}
		return Response.instance(Status.SUCCESS, "发帖成功");
	}
	
	@RequestMapping("/getArticle")
	public Response getArticle(Long id) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("article",  articleService.getArticle(id));
		result.put("comments", commentService.list(id));
		return Response.SUCCESS.data(result);
	}
	
	@RequestMapping("/{id}")
	public Response getArticle(@PathVariable("id") long id) {
		if(0L==id) {
			return Response.instance(Status.REQUEST_PARAM_ERROR, "非法请求");
		}
		
		ArticleInfo article = null;
		try {
			article = articleService.findInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.instance(Status.SYSTEM_ERROR);
		}
		if(null==article) {
			return Response.instance(Status.REQUEST_NOT_EXIST_ERROR, "帖子不存在或已被删除");
		}
		article.setViewNum(article.getViewNum()+1);
		return Response.instance("查询成功", article);
	}
	
	@RequestMapping("/list/{page}/{pageSize}")
	public Response listArticle(ArticleList paras, @PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
		PageQuery<ArticleList> query = new PageQuery<>();
		query.setParas(paras);
		query.setPageNumber(page);
		query.setPageSize(pageSize);
		try {
			query = articleService.findListByCondition(query);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.instance(Status.SYSTEM_ERROR);
		}
		
		Map<String, Object> data = new HashMap<>();
		data.put("articleList", query.getList());
		data.put("currentPage", query.getPageNumber());
		data.put("maxPage", query.getTotalPage());
		data.put("total", query.getTotalRow());
		
		return Response.instance("查询成功", data);
	}
	
}
