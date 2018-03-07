/**
 * 
 */
package org.applesline.forum.service;

import javax.annotation.PostConstruct;

import org.applesline.forum.dao.ThemeDao;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月9日
 */
@Service
public class ThemeService {

	@Autowired
	SQLManager sqlManager;
	
	ThemeDao themeDao;
	
	@PostConstruct
	public void init() {
		themeDao = sqlManager.getMapper(ThemeDao.class);
	}
	
}
