package com.touwoxin.chapter82.dao;


import com.touwoxin.chapter82.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface UserMapper {
    int saveUser(User user);
    int updateUserPassword(User user);
    List<User> queryUsers();
    User queryUserById(Long id);
    int deleteUserById(Long id);
}
