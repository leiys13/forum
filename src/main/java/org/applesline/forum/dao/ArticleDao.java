/**
 * 
 */
package org.applesline.forum.dao;

import java.util.List;

import org.applesline.forum.model.Article;
import org.applesline.forum.vo.ArticleInfo;
import org.applesline.forum.vo.ArticleList;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.engine.PageQuery;
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
	
	/**
	 * 查询帖子列表（帖子基本信息、发帖人信息、分页查询）
	 * @param query 查询条件
	 * @return
	 */
	public PageQuery<ArticleList> selectListByCondition(PageQuery<ArticleList> query);
	
	/**
	 * 查询一个帖子的详细信息（帖子内容、发帖人信息）
	 * @param param 查询条件
	 * @return
	 */
	public ArticleInfo selectInfoById(@Param("id") long id);
	
	/**
	 * 浏览量 +1
	 * @param id
	 */
	public void incrementViewNum(@Param("id") long id);
	
}
