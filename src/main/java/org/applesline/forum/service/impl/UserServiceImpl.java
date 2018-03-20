/**
 * 
 */
package org.applesline.forum.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.applesline.forum.dao.UserDao;
import org.applesline.forum.model.User;
import org.applesline.forum.service.UserService;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月9日
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	SQLManager sqlManager;

	UserDao userDao;
	
	@PostConstruct
	public void init() {
		userDao = sqlManager.getMapper(UserDao.class);
	}
	
	@Override
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> listUser() {
		return userDao.listUser();
	}

	@Override
	public boolean exist(String username) {
		return userDao.findByName(username) > 0;
	}

	@Override
	public User checkLogin(String username,String password) {
		return userDao.checkLogin(username,password);
	}

}
