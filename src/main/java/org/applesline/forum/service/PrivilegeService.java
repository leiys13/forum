/**
 * 
 */
package org.applesline.forum.service;

import javax.annotation.PostConstruct;

import org.applesline.forum.dao.PrivilegeDao;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月9日
 */
@Service
public class PrivilegeService {

	@Autowired
	SQLManager sqlManager;
	
	PrivilegeDao privilegeDao;
	
	@PostConstruct
	public void init() {
		privilegeDao = sqlManager.getMapper(PrivilegeDao.class);
	}
	
}
