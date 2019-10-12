package com.touwoxin.chapter82.dao;

import com.touwoxin.chapter82.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    //添加用户
    @Test
    public void testSaveUser() throws Exception {
        userMapper.saveUser(new User("user111", "111", "111@qq.com"));
        userMapper.saveUser(new User("user222", "222", "222@qq.com"));

        assertThat(userMapper.queryUsers().size(),is(7));
    }

    //修改密码
    @Test
    public void testUpdateUserPassword() throws Exception {
        User user = userMapper.queryUserById((long) 27);
        //System.out.println(user.getPassword());
        user.setPassword("pwd333");
        userMapper.updateUserPassword(user);
        assertThat(userMapper.queryUserById((long) 27).getPassword(),is("pwd333"));
    }

    //查询用户
    @Test
    public void testQueryUsers() throws Exception {
        List<User> users = userMapper.queryUsers();
        assertThat(users.size(),is(7));
        //System.out.println(users.size());
    }
}
