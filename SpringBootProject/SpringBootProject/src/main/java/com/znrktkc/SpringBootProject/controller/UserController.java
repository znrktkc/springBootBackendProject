package com.znrktkc.SpringBootProject.controller;

import com.znrktkc.SpringBootProject.entity.User;
import com.znrktkc.SpringBootProject.repo.UserRepository;
import com.znrktkc.SpringBootProject.service.UserService;
import com.znrktkc.SpringBootProject.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * this class is an controller for user api
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        logger.debug("get started with username: {}",user.getUsername());
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<User> getUser(@RequestParam String username) {
        logger.debug("get started with username: {}", username);
        return ResponseEntity.ok(userService.getUser(username));
    }

    @RequestMapping(method = RequestMethod.POST, value  = "/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        logger.debug("get started with username: {}",user.getUsername());
        return ResponseEntity.ok(userService.getUser(user.getUsername()));
    }
}
