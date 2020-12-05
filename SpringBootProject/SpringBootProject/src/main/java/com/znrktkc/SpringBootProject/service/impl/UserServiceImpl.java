package com.znrktkc.SpringBootProject.service.impl;

import com.znrktkc.SpringBootProject.entity.User;
import com.znrktkc.SpringBootProject.repo.UserRepository;
import com.znrktkc.SpringBootProject.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * this method can use for user save
     * @param user
     * @return
     */
    @Override
    public User save(User user) {
        User newUser = new User();
        newUser.setUser(user);
        return userRepository.save(newUser);
    }

    /**
     * this method created for find the user from user table
     * @param username
     * @return this method return to exception or user info
     * @throws UsernameNotFoundException
     */
    @Override
    public User getUser(String username)  throws UsernameNotFoundException {
        Optional<User> byUsername = Optional.ofNullable(userRepository.findByUsername(username));
        return byUsername.orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }
}
