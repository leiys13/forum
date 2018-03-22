/**
 * 
 */
package org.applesline.forum.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.applesline.forum.base.BaseController;
import org.applesline.forum.base.Response;
import org.applesline.forum.base.Status;
import org.applesline.forum.common.Consts;
import org.applesline.forum.model.Comments;
import org.applesline.forum.model.User;
import org.applesline.forum.service.ArticleService;
import org.applesline.forum.service.CommentService;
import org.applesline.forum.util.StringUtil;
import org.applesline.forum.vo.CommentsList;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月6日
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {
	
	private static final long serialVersionUID = -4190578620562376661L;
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/add")
	public Response add(String content,long articleId) {
		if(StringUtil.isEmpty(content)) {
			return Response.instance(Status.REQUEST_PARAM_ERROR, "评论内容不能为空");
		}
		if(null==articleService.findById(articleId)) {
			return Response.instance(Status.REQUEST_NOT_EXIST_ERROR, "评论的帖子不存在或已被删除");
		}
		User loginUser = (User) super.getRequest().getSession().getAttribute(Consts.LOGIN_USER);
		Comments comments = new Comments();
		comments.setArticleId(articleId);
		comments.setContent(content);
		comments.setCreateTime(new Date());
		comments.setUserId(loginUser.getId());
		try {
			comments = commentService.add(comments);
			if(null!=comments) {
				// 将评论信息包装成更适合的数据返回客户端
				CommentsList commentsList = new CommentsList(comments);
				commentsList.setUserId(loginUser.getId());
				commentsList.setUserName(loginUser.getUserName());
				commentsList.setNickName(loginUser.getNickName());
				commentsList.setProfilePic(loginUser.getProfilePic());
				return Response.instance("评论成功", commentsList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.instance(Status.SYSTEM_ERROR);
	}
	
	@RequestMapping("/list/{page}/{pageSize}")
	public Response list(CommentsList paras, @PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
		if(paras.getArticleId()<=0) {
			return Response.instance(Status.REQUEST_PARAM_ERROR, "非法请求");
		}
		if(null==articleService.findById(paras.getArticleId())) {
			return Response.instance(Status.REQUEST_NOT_EXIST_ERROR, "帖子不存在或已被删除");
		}
		
		PageQuery<CommentsList> query = new PageQuery<>();
		query.setParas(paras);
		query.setPageNumber(page);
		query.setPageSize(pageSize);
		try {
			query = commentService.findListByCondition(query);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.instance(Status.SYSTEM_ERROR);
		}
		
		Map<String, Object> data = new HashMap<>();
		data.put("commentList", query.getList());
		data.put("currentPage", query.getPageNumber());
		data.put("maxPage", query.getTotalPage());
		data.put("total", query.getTotalRow());
		
		return Response.instance("查询成功", data);
	}
	
}
