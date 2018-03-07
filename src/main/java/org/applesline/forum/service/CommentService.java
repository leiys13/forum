/**
 * 
 */
package org.applesline.forum.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.applesline.forum.dao.CommentsDao;
import org.applesline.forum.model.Comments;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月9日
 */
@Service
public class CommentService {

	@Autowired
	SQLManager sqlManager;
	
	CommentsDao commentsDao;
	
	@PostConstruct
	public void init() {
		commentsDao = sqlManager.getMapper(CommentsDao.class);
	}
	
	public void addComment(Comments comments) {
		commentsDao.adComment(comments);
	}
	
	public List<Comments> list() {
		return commentsDao.list();
	}
	
}
