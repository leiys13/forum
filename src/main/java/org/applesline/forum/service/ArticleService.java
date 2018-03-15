/**
 * 
 */
package org.applesline.forum.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.applesline.forum.dao.ArticleDao;
import org.applesline.forum.model.Article;
import org.applesline.forum.util.IdGenerator;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月2日
 */
@Service
public class ArticleService {

	@Autowired
	SQLManager sqlManager;
	
	ArticleDao articleDao;
	
	@PostConstruct
	public void init() {
		articleDao = sqlManager.getMapper(ArticleDao.class);
	}
	
	public Article getArticle(long id) {
		return articleDao.getArticle(id);
	}
	
	public void delete(long id) {
		articleDao.delete(id);
	}
	
	public void addArticle(Article article) {
		article.setId(IdGenerator.generateId());
		articleDao.addArticle(article);
	}
	
	public List<Article> listArticle() {
		return articleDao.listArticle();
	}
	
	public boolean exist(String title) {
		return articleDao.findByTitle(title) > 0;
	}
}
