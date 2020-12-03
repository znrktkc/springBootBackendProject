package com.znrktkc.SpringBootProject.service;

import com.znrktkc.SpringBootProject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    User save(User user);
    User getUser(String username);
}
