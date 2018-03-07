/**
 * 
 */
package org.applesline.forum.controller;

import java.util.Date;

import org.applesline.forum.base.Response;
import org.applesline.forum.model.Comments;
import org.applesline.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月6日
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@RequestMapping("/add")
	@ResponseBody
	public Response add(String text,Integer articleId) {
		Comments comments = new Comments();
		comments.setArticleId(articleId);
		comments.setContent(text);
		comments.setCreateTime(new Date());
		comments.setUserId(1);
		commentService.addComment(comments);
		return Response.SUCCESS.data("{success:'haha'}");
	}
	
}
