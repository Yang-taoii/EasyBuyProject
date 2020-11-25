package com.kgc.service.user;

import com.kgc.pojo.Page;
import com.kgc.pojo.User;

import java.util.List;

public interface UserService {
    Page fenYe(Page page);
    int fenYeCount();


    int add(User user) throws Exception;//新增用户信息
    List<User> getUserList() throws Exception;//查询全部用户信息
}
