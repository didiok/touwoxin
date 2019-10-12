package com.touwoxin.chapter5;

import com.touwoxin.chapter5.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter5ApplicationTests {

    @Autowired
    private UserService userSerivce;

    @Test
    public void test() throws Exception {

        // 之前创建数据库时已经插入3个用户

        // 查数据库用户个数，应该等于3
        assertThat(userSerivce.queryUsers().size(), is(3));

        // 更改密码
        userSerivce.updateUserPassword((long) 99, "pwd");
        //密码应该改为 pwd
        assertThat(userSerivce.queryUserById((long) 99).getPassword(), is("pwd"));

        // 删除用户
        userSerivce.deleteUserById((long) 99);
        // 应该还剩2个用户
        assertThat(userSerivce.queryUsers().size(), is(2));


    }
}
