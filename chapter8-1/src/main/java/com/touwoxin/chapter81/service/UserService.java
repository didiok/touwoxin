package com.touwoxin.chapter81.service;

import com.touwoxin.chapter81.model.User;

import java.util.List;

public interface UserService {
    int saveUser(User user);
    int updateUserPassword(User user);
    List<User> queryUsers();
    User queryUserById(Long id);
    int deleteUserById(Long id);
}
