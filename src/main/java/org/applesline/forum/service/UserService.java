package org.applesline.forum.service;

import java.util.List;

import org.applesline.forum.model.User;

/**
 * @date 2018年3月20日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface UserService {

	public User getUser(Integer id);

	public void addUser(User user);

	public List<User> listUser();

	public boolean exist(String username);
	
	public User checkLogin(String username,String password) ;
	
}
