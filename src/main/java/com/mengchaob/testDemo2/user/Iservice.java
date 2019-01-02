package com.mengchaob.testDemo2.user;

import java.util.List;

/**
 * @Auther: mengchao
 * @Date: 2018-12-27 09:53
 * @Description:
 * @Version 1.0
 * @ClassName Iservice
 */
public interface Iservice {
    void addUser(User user);
    List showUsers(User user);
}
