package com.niu.demo.repository;

import com.niu.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);

    List<User> findByUserNameContaining(String userName);


}
