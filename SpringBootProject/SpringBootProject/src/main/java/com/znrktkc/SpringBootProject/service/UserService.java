package com.znrktkc.SpringBootProject.service;
import com.znrktkc.SpringBootProject.entity.User;

/**
 * this service created to bring user info and user save
 */
public interface UserService {
    User save(User user);
    User getUser(String username);
}
