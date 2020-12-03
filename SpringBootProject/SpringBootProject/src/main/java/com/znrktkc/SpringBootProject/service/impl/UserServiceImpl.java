package com.znrktkc.SpringBootProject.service.impl;

import com.znrktkc.SpringBootProject.entity.User;
import com.znrktkc.SpringBootProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class UserServiceImpl extends SavedRequestAwareAuthenticationSuccessHandler implements UserDetailsService {

    public static void saveCookie(String cookieName, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, value);
        //maxAge is one month: 30*24*60*60
        cookie.setMaxAge(2592000);
        cookie.setDomain("projectName");
        cookie.setPath("/");
        response.addCookie(cookie);
    }


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return (UserDetails) new UsersDetails(user);
    }
}
