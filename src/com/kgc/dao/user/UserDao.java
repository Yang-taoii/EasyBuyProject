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



	int updateUserInfo(User user) ;//更新用户信息
	int deleteUserById(String name) ;
	int insertUserInfo(User user);
	User selectUserByName(String name);
	
	List<User> getUserList() ;

}
