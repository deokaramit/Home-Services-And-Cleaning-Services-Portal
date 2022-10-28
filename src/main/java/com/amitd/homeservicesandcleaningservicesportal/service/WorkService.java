package com.amitd.homeservicesandcleaningservicesportal.service;

import java.util.List;
import java.util.Optional;

import com.amitd.homeservicesandcleaningservicesportal.repo.WorkDao;
import com.amitd.homeservicesandcleaningservicesportal.beans.Work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkService {

    @Autowired
    WorkDao workDao;

    public Work save(Work p) {
        return workDao.save(p);
    }

    public List<Work> show() {
        return workDao.findAll();
    }

    public Optional<Work> findWork(int id) {
        return workDao.findById(id);
    }

    public void delete(int id) {
        workDao.deleteById(id);
    }

    public void multiDelete(List<Integer> id) {
        workDao.deleteAllById(id);
    }

    public Work update(Work u) {
        return workDao.save(u);
    }

    public List<Work> searchBetweenDays(String s1, String e1) {
        return workDao.betweenDate(s1, e1);
    }

}
