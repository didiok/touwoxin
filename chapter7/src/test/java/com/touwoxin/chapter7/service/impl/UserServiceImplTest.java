package com.touwoxin.chapter7.service.impl;

import com.touwoxin.chapter7.Chapter7Application;
import com.touwoxin.chapter7.model.User;
import com.touwoxin.chapter7.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter7Application.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void saveUserTest() {
        userService.saveUser("xiao ming","123456","111@qq.com");
    }

    @Test
    public void queryUserByIdTest(){
        User user=userService.queryUserById((long) 1);
        assertThat(user.getUsername(),is("xiao ming"));
    }
}
