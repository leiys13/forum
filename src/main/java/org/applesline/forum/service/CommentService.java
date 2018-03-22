package org.applesline.forum.service;

import java.util.List;

import org.applesline.forum.model.Comments;
import org.applesline.forum.vo.CommentsList;
import org.beetl.sql.core.engine.PageQuery;

/**
 * @date 2018年3月22日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface CommentService {
	
	public void addComment(Comments comments);
	
	public List<Comments> list(long articleId);
	
	public Comments add(Comments comments);
	
	public PageQuery<CommentsList> findListByCondition(PageQuery<CommentsList> query);

}
