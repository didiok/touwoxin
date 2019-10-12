package com.touwoxin.chapter3.dao;

import com.touwoxin.chapter3.Chapter3Application;
import com.touwoxin.chapter3.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {

        userRepository.save(new User("user111", "111", "111@qq.com"));
        userRepository.save(new User("user222", "222", "222@qq.com"));
        userRepository.save(new User("user333", "333", "333@qq.com"));

        assertThat(userRepository.findAll().size(),is(3));
        assertThat(userRepository.findByUsernameOrEmail("user222", "222@qq.com").getPassword(),is("222"));
        assertThat(userRepository.findByUsername("user111").getEmail(), is ("111@qq.com"));
    }


}