package com.amitd.homeservicesandcleaningservicesportal.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.amitd.homeservicesandcleaningservicesportal.repo.RoleDao;
import com.amitd.homeservicesandcleaningservicesportal.repo.UserDao;
import com.amitd.homeservicesandcleaningservicesportal.beans.Role;
import com.amitd.homeservicesandcleaningservicesportal.beans.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User save(User u) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        u.setPassword(encoder.encode(u.getPassword()));

        User u1 = userDao.save(u);

        return u1;
    }

    public List<User> show() {
        return userDao.findAll();
    }

    public User findUser(int id) {
        return userDao.findById(id).get();
    }

    public void delete(int id) {
        userDao.deleteById(id);
    }

    public void multiDelete(List<Integer> id) {
        userDao.deleteAllById(id);
    }

    public User update(User u) {
        return userDao.save(u);
    }

    public List<User> searchBetweenDays(String s1, String e1) {
        return userDao.betweenDate(s1, e1);
    }

    public void addRoleToUser(String username, String rolename) {
        User user = userDao.findByUsername(username);
        Role role = roleDao.findByName(rolename);

        user.getRoles().add(role);
        role.getUsers().add(user);

        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        Collection<SimpleGrantedAuthority> authrities = new ArrayList<>();

        user.getRoles().forEach(role -> {
            authrities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authrities);
    }

    public User findUserName(String username) {
        return userDao.findByUsername(username);
    }

    public User findUserById(int id) {
        Optional<User> u = userDao.findById(id);
        return u.get();
    }

    public List<User> findUserByWork(int id) {
        return userDao.findUserByWork(id);
    }

}
