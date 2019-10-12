package com.touwoxin.chapter5.service;

import com.touwoxin.chapter5.model.User;

import java.util.List;

public interface UserService {
    int saveUser(String username, String password, String email);

    int updateUserPassword(Long id, String password);

    List<User> queryUsers();

    User queryUserById(Long id);

    int deleteUserById(Long id);
}
