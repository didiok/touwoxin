package com.touwoxin.chapter5.service.impl;

import com.touwoxin.chapter5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.touwoxin.chapter5.dao.UserDAO;
import java.util.List;

@Service
public class UserServiceImpl implements com.touwoxin.chapter5.service.UserService {
    @Autowired
    UserDAO userDao;
    @Override
    public int saveUser(String username,String password,String email ) {
        return this.userDao.saveUser(username,password,email );
    }

    @Override
    public int updateUserPassword(Long id,String password) {
        return this.userDao.updateUserPassword(id,password);
    }

    @Override
    public List<User> queryUsers() {
        return this.userDao.queryUsers();
    }

    @Override
    public User queryUserById(Long id) {
        return this.userDao.queryUserById(id);
    }

    @Override
    public int deleteUserById(Long id) {
        return this.userDao.deleteUserById(id);
    }


}
