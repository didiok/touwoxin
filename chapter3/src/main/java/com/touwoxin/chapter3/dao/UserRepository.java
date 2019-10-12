package com.touwoxin.chapter3.dao;

import com.touwoxin.chapter3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByUsernameOrEmail(String username, String email);

}
