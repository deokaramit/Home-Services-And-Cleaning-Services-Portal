package com.amitd.homeservicesandcleaningservicesportal.service;

import java.util.List;
import java.util.Optional;

import com.amitd.homeservicesandcleaningservicesportal.repo.RoleDao;
import com.amitd.homeservicesandcleaningservicesportal.beans.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public Role save(Role p) {
        return roleDao.save(p);
    }

    public List<Role> show() {
        return roleDao.findAll();
    }

    public Optional<Role> findRole(int id) {
        return roleDao.findById(id);
    }

    public void delete(int id) {
        roleDao.deleteById(id);
    }

    public void multiDelete(List<Integer> id) {
        roleDao.deleteAllById(id);
    }

    public Role update(Role u) {
        return roleDao.save(u);
    }

    public List<Role> searchBetweenDays(String s1, String e1) {
        return roleDao.betweenDate(s1, e1);
    }

}
