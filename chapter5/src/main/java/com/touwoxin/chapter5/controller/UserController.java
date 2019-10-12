package com.touwoxin.chapter5.controller;

import com.touwoxin.chapter5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.touwoxin.chapter5.service.UserService;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("saveUser")
    public String saveUser(String username,String password,String email ){
        int rows= userService.saveUser(username,password,email);
        return "执行成功，影响"+rows+"行";
    }



    @GetMapping("updateUserPassword")
    public String updateUserPassword(Long id,String password){
        int rows= userService.updateUserPassword(id,password);
        return "执行成功，影响"+rows+"行";
    }


    @GetMapping("queryUsers")
    public List<User> queryUsers() {
        // 查询所有用户
        List<User> list= userService.queryUsers();
        return list;
    }


    @GetMapping("queryUserById")
    public User queryUserById(Long id) {
        // 根据主键ID查询
        User user= userService.queryUserById(id);
        return user;
    }


    @GetMapping("deleteUserById")
    public String deleteUserById(Long id){
        int rows= userService.deleteUserById(id);
        return "执行成功，影响"+rows+"行";
    }
}
