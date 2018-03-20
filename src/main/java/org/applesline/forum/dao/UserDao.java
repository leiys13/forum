/**
 * 
 */
package org.applesline.forum.dao;

import java.util.List;

import org.applesline.forum.model.User;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月8日
 */
public interface UserDao extends BaseMapper<User> {

	User getUser(@Param("id")Integer id);
	
	void addUser(User user);
	
	List<User> listUser();
	
	int findByName(@Param("username")String username);
	
	User checkLogin(@Param("username")String username,@Param("password")String password);
}
