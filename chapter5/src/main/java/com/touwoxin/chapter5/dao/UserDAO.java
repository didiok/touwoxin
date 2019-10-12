package com.touwoxin.chapter5.dao;

import com.touwoxin.chapter5.model.User;

import java.util.List;

public interface UserDAO {
    int saveUser(String username,String password,String email );
    int updateUserPassword(Long id,String password);
    List<User> queryUsers();
    User queryUserById(Long id);
    int deleteUserById(Long id);

}
