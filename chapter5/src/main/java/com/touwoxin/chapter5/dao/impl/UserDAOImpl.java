package com.touwoxin.chapter5.dao.impl;

import com.touwoxin.chapter5.dao.UserDAO;
import com.touwoxin.chapter5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveUser(String username,String password, String email ) {
        return jdbcTemplate.update("insert into user (username,password,email) values (?,?,?)",username,password,email );
    }

    @Override
    public int updateUserPassword(Long id,String password) {
        return jdbcTemplate.update("update user set password = ? where id = ?",password,id);
    }

    @Override
    public List<User> queryUsers() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql,new Object[]{}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User queryUserById(Long id){
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public int deleteUserById(Long id) {
        return jdbcTemplate.update("delete from  user  where id = ?",id);
    }

}
