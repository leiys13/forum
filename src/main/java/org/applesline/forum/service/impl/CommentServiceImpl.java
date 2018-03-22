/**
 * 
 */
package org.applesline.forum.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.applesline.forum.dao.CommentsDao;
import org.applesline.forum.model.Comments;
import org.applesline.forum.service.CommentService;
import org.applesline.forum.vo.CommentsList;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月9日
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	SQLManager sqlManager;
	
	CommentsDao commentsDao;
	
	@PostConstruct
	public void init() {
		commentsDao = sqlManager.getMapper(CommentsDao.class);
	}

	@Override
	public void addComment(Comments comments) {
		commentsDao.adComment(comments);
	}

	@Override
	public List<Comments> list(long articleId) {
		return commentsDao.list(articleId);
	}

	@Override
	public Comments add(Comments comments) {
		int r = sqlManager.insert(comments, true);
		if(1==r) {
			return comments;
		}
		return null;
	}

	@Override
	public PageQuery<CommentsList> findListByCondition(PageQuery<CommentsList> query) {
		return commentsDao.selectListByCondition(query);
	}
	
}
