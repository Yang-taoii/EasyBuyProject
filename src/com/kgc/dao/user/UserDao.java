package com.kgc.dao.user;


import com.kgc.pojo.Page;
import com.kgc.pojo.User;
import java.util.List;

/***
 * UserDao 用户业务的dao层
 * 从父类继承下的被使用的方法
 * User getById(userId);
 * Integer userDao.getRowCount(params);
 * List<User> userDao.getRowList(params);
 */
public interface UserDao{

	List<User> fenYe(Page page);

	int fenYeCount();

	int add(User user) throws Exception;//新增用户信息

	int updateInfo(User user) throws Exception;//更新用户信息

	int deleteUserById(String id) throws Exception;
	
	List<User> getUserList() throws Exception;
	
	int count() throws Exception;
	
	User getUser(int uid,String loginName) throws Exception;
}
