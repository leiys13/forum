/**
 * 
 */
package org.applesline.forum.service;

import org.applesline.forum.TestSuper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 文章服務測試用例
 * 
 * @author liuyaping
 *
 * 创建时间：2018年3月8日
 */
public class ArticleServiceTest extends TestSuper {

	@Autowired
	private ArticleService articleService;
	
	@Test
	public void testListArticle() {
		System.out.println(articleService.listArticle());
	}
}
