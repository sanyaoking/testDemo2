package com.mengchaob.testDemo2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: mengchao
 * @Date: 2018-12-27 09:53
 * @Description:
 * @Version 1.0
 * @ClassName service
 */
@Service
public class service implements Iservice {

    private UserDao userDao;

    @Autowired
    public service(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        this.userDao.add(user);
    }

    @Override
    public List showUsers(User user) {
        return userDao.showUsers();
    }

}
