package com.amitd.homeservicesandcleaningservicesportal.service;

import java.util.List;
import java.util.Optional;

import com.amitd.homeservicesandcleaningservicesportal.repo.TagDao;
import com.amitd.homeservicesandcleaningservicesportal.beans.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    TagDao tagDao;

    public Tag save(Tag p) {
        return tagDao.save(p);
    }

    public List<Tag> show() {
        return tagDao.findAll();
    }

    public Optional<Tag> findTag(int id) {
        return tagDao.findById(id);
    }

    public void delete(int id) {
        tagDao.deleteById(id);
    }

    public void multiDelete(List<Integer> id) {
        tagDao.deleteAllById(id);
    }

    public Tag update(Tag u) {
        return tagDao.save(u);
    }

    public List<Tag> searchBetweenDays(String s1, String e1) {
        return tagDao.betweenDate(s1, e1);
    }

}
