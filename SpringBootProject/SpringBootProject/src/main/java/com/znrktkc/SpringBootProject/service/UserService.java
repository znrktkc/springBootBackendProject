package com.znrktkc.SpringBootProject.service;

import com.znrktkc.SpringBootProject.entity.Role;
import com.znrktkc.SpringBootProject.entity.User;
import com.znrktkc.SpringBootProject.repo.RoleRepository;
import com.znrktkc.SpringBootProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {
}