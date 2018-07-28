package com.example.rentcar.dao;

import com.example.rentcar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String name);

    User findByUsernameAndUserpwd(String username,String userpwd);
}
