package com.touwoxin.chapter82.controller;

import com.touwoxin.chapter82.model.User;
import com.touwoxin.chapter82.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @GetMapping("saveUser")
    public String saveUser(User user){
        int rows= userService.saveUser(user);
        return "执行成功，影响"+rows+"行";
    }


    //修改密码
    @GetMapping("updateUserPassword")
    public String updateUserPassword(User user){
        int rows= userService.updateUserPassword(user);
        return "执行成功，影响"+rows+"行";
    }

    //查询用户
    @GetMapping("queryUsers")
    public List<User> queryUsers() {
        // 查询所有用户
        List<User> list= userService.queryUsers();
        return list;
    }

    //通过ID查询用户
    @GetMapping("queryUserById")
    public User queryUserById(Long id) {
        // 根据主键ID查询
        User user= userService.queryUserById(id);
        return user;
    }

    //删除用户
    @GetMapping("deleteUserById")
    public String deleteUserById(Long id){
        int rows= userService.deleteUserById(id);
        return "执行成功，影响"+rows+"行";
    }
}
