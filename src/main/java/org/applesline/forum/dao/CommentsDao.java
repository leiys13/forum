/**
 * 
 */
package org.applesline.forum.dao;

import java.util.List;

import org.applesline.forum.model.Comments;
import org.beetl.sql.core.mapper.BaseMapper;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月8日
 */
public interface CommentsDao extends BaseMapper<Comments> {

	void adComment(Comments comments);
	
	List<Comments> list();
}
