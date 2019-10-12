package com.touwoxin.chapter6.dao;

import com.touwoxin.chapter6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("from User u where u.username=:username")
    User findUser(@Param("username") String username);

    User findByUsernameAndEmail(String username, String email);

    @Modifying
    @Query("update User u set u.username = ?1 where u.id = ?2")
    int updateUsernameById(String username, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteUserById(Long id);

    @Transactional(timeout = 10)
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

}
