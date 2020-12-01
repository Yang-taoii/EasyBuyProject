package com.kgc.service.user;

import com.kgc.dao.user.UserDao;
import com.kgc.dao.user.UserDaoImpl;
import com.kgc.pojo.Page;
import com.kgc.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService{
UserDao userDao = new UserDaoImpl();

    @Override
    public Page fenYe(Page page) {
        int index = page.getPageIndex();
        int size = page.getPageSize();

        int realIndex = (index-1)*size;

        Page page1 = new Page(realIndex,size);
        List<User> list = userDao.fenYe(page1);
        int totalCount = userDao.fenYeCount();

        int totalPage=0;
        if(totalCount>0){
            totalPage=totalCount%size==0?(totalCount/size):(totalCount/size+1);
        }

        Page page2 = new Page();
        page2.setList(list);
        page2.setPageIndex(index);
        page2.setPageSize(size);
        page2.setTotalPage(totalPage);
        page2.setTotalCount(totalCount);

        return page2;
    }

    @Override
    public int fenYeCount() {
        return userDao.fenYeCount();
    }


    @Override
    public int add(User user) throws Exception {
        return userDao.add(user);
    }

    @Override
    public List<User> getUserList() throws Exception {
        return userDao.getUserList();
    }

    //删除
    public int deleteUserInfo(String name) {
        return userDao.deleteUserById(name);
    }
    //新增
    public int insertUserInfo(User user) {
        return userDao.insertUserInfo(user);
    }
    //修改
    public int updateUserInfo(User user) {
        return userDao.updateUserInfo(user);
    }

    @Override
    public User selectUserByName(String name) {
        return userDao.selectUserByName(name);
    }


}
