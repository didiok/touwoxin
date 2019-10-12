package com.touwoxin.chapter82.service.impl;

import com.touwoxin.chapter82.dao.UserMapper;
import com.touwoxin.chapter82.model.User;
import com.touwoxin.chapter82.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public int saveUser(User user) {
        return this.userMapper.saveUser(user);
    }

    @Override
    public int updateUserPassword(User user) {
        return this.userMapper.updateUserPassword(user);
    }

    @Override
    public List<User> queryUsers() {
        return this.userMapper.queryUsers();
    }

    @Override
    public User queryUserById(Long id) {
        return this.userMapper.queryUserById(id);
    }

    @Override
    public int deleteUserById(Long id) {
        return this.userMapper.deleteUserById(id);
    }
}
