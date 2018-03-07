/**
 * 
 */
package org.applesline.forum.dao;

import java.util.List;

import org.applesline.forum.model.Article;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月8日
 */
public interface ArticleDao extends BaseMapper<Article> {

	Article getArticle(@Param("id")long id);
	
	void addArticle(Article article);
	
	List<Article> listArticle();
	
	int findByTitle(@Param("title")String title);
	
	void delete(@Param("id")long id);
	
}
