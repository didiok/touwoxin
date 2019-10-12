package com.touwoxin.chapter6.dao;

import com.touwoxin.chapter6.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {

        userRepository.save(new User((long) 111,"user111", "111","111@qq.com"));
        userRepository.save(new User((long) 222,"user222", "222","222@qq.com"));
        userRepository.save(new User((long) 333,"user333", "333","333@qq.com"));

        // 测试findByUserame方法
        assertThat(userRepository.findByUsername("user111").getEmail(), is("111@qq.com"));

        // 测试findByUserameAndEmail方法
        assertThat(userRepository.findByUsernameAndEmail("user111","111@qq.com").getPassword(), is("111"));

        // 测试findAll方法
        assertThat(userRepository.findAll().size(),is(3));

        Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Order.desc("username")));
        final Page<User> users = userRepository.findAll(pageable);
        assertThat(users.getTotalPages(),is(1));

    }


}