/**
 * 
 */
package org.applesline.forum.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.applesline.forum.dao.ArticleDao;
import org.applesline.forum.model.Article;
import org.applesline.forum.service.ArticleService;
import org.applesline.forum.vo.ArticleInfo;
import org.applesline.forum.vo.ArticleList;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月2日
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private SQLManager sqlManager;
	
	private ArticleDao articleDao;
	
	@PostConstruct
	public void init() {
		articleDao = sqlManager.getMapper(ArticleDao.class);
	}

	@Override
	public Article getArticle(long id) {
		return articleDao.getArticle(id);
	}

	@Override
	public void delete(long id) {
		articleDao.delete(id);
	}

	@Override
	public void addArticle(Article article) {
		article.setCreateTime(new Date());
		article.setUpdateTime(new Date());
		articleDao.insertTemplate(article);
	}

	@Override
	public List<Article> listArticle() {
		return articleDao.listArticle();
	}
	
	@Override
	public Article findById(long id) {
		return articleDao.single(id);
	}

	@Override
	public PageQuery<ArticleList> findListByCondition(PageQuery<ArticleList> query) {
		return articleDao.selectListByCondition(query);
	}
	
	@Override
	public ArticleInfo findInfoById(long id) {
		ArticleInfo result = articleDao.selectInfoById(id);
		if(null!=result) {
			articleDao.incrementViewNum(id);
		}
		return result;
	}
	
	@Override
	public ArticleInfo getInfoById(long id) {
		ArticleInfo result = articleDao.selectInfoById(id);
		return result;
	}

	@Override
	public void incrementViewNum(long id) {
		articleDao.incrementViewNum(id);
	}

	@Override
	public boolean exist(String title) {
		return articleDao.findByTitle(title) > 0;
	}
}
