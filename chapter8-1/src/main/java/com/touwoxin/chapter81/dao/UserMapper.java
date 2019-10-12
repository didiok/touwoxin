package com.touwoxin.chapter81.dao;


import com.touwoxin.chapter81.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    @Insert("insert into user(username, password, email) values(#{username},#{password},#{email})")
    int saveUser(User user);

    @Update("update user set password=#{password} where id = #{id}")
    int updateUserPassword(User user);

    @Select("select * from user")
    @Results({
            @Result(property = "username",  column = "username", javaType = String.class),
            @Result(property = "email", column = "email", javaType = String.class)
    })
    List<User> queryUsers();

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "username",  column = "username", javaType = String.class),
            @Result(property = "email", column = "email", javaType = String.class)
    })
    User queryUserById(Long id);

    @Delete("delete from user where id =#{id}")
    int deleteUserById(Long id);
}
