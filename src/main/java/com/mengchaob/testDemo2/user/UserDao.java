package com.mengchaob.testDemo2.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: mengchao
 * @Date: 2018-12-27 10:26
 * @Description:
 * @Version 1.0
 * @ClassName UserDao
 */
public interface UserDao {
    @Insert("insert into users value (#{id},#{nick_name},#{avatar_url},#{gender},#{open_id},#{session_key},sysdate(),sysdate())")
    public void add(User user);
    @Select("select * from users")
    public List<User> showUsers();
}
