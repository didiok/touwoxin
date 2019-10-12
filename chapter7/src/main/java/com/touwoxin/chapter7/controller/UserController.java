package com.touwoxin.chapter7.controller;

import com.touwoxin.chapter7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.touwoxin.chapter7.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(value="/saveUser")
    @ResponseBody
    public Map<String,Object> saveUser(@RequestBody User user) {
        userService.saveUser(user.getUsername(),user.getPassword(),user.getEmail());
        Map<String,Object> params = new HashMap<>();
        params.put("code", "success");
        return params;
    }

    /**
     * 获取用户信息
     * @param id
     */
    @GetMapping(value="/queryUserById/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable(value = "id") Long id){
        User user = userService.queryUserById(id);
        return user;
    }

}
