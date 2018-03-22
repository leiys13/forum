package org.applesline.forum.service;

import java.util.List;

import org.applesline.forum.model.Article;
import org.applesline.forum.vo.ArticleInfo;
import org.applesline.forum.vo.ArticleList;
import org.beetl.sql.core.engine.PageQuery;

/**
 * @date 2018年3月22日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface ArticleService {
	
	public Article getArticle(long id);
	
	public void delete(long id);
	
	public void addArticle(Article article);
	
	public List<Article> listArticle();
	
	public Article findById(long id);
	
	public PageQuery<ArticleList> findListByCondition(PageQuery<ArticleList> query);
	
	public ArticleInfo findInfoById(long id);
	
	public ArticleInfo getInfoById(long id);
	
	public void incrementViewNum(long id);
	
	public boolean exist(String title);

}
