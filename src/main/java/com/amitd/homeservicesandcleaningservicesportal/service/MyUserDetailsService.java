package com.amitd.homeservicesandcleaningservicesportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.amitd.homeservicesandcleaningservicesportal.repo.UserDao;
import com.amitd.homeservicesandcleaningservicesportal.beans.Role;
import com.amitd.homeservicesandcleaningservicesportal.beans.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service
public class MyUserDetailsService {

    @Autowired
    UserDao userDao;

    // @Override
    // public UserDetails loadUserByUsername(String username) throws
    // UsernameNotFoundException {
    // User user = userDao.findByUsername(username);
    // if (user == null) {
    // throw new UsernameNotFoundException("Could not find User");
    // }
    // // new UserPrinciple(user);

    // Set<Role> roles = user.getRoles();
    // List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    // for (Role role : roles) {
    // authorities.add(new SimpleGrantedAuthority(role.getName()));
    // }

    // return new
    // org.springframework.security.core.userdetails.User(user.getUsername(),
    // user.getPassword(),
    // authorities);
    // }

}
