/**
 * 
 */
package org.applesline.forum.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.applesline.forum.dao.UserDao;
import org.applesline.forum.model.User;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月9日
 */
@Service
public class UserService {

	@Autowired
	SQLManager sqlManager;
	
	UserDao userDao;
	
	@PostConstruct
	public void init() {
		userDao = sqlManager.getMapper(UserDao.class);
	}
	
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}


	public void addUser(User user) {
		userDao.addUser(user);
	}

	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userDao.listUser();
	}

	public boolean exist(String username) {
		// TODO Auto-generated method stub
		return userDao.findByName(username) > 0;
	}
	
	public boolean checkLogin(String username,String password) {
		// TODO Auto-generated method stub
		return userDao.checkLogin(username,password) > 0;
	}

}
