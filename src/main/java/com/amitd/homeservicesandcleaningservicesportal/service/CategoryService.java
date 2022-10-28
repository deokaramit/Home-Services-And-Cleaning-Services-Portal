package com.amitd.homeservicesandcleaningservicesportal.service;

import java.util.List;
import java.util.Optional;

import com.amitd.homeservicesandcleaningservicesportal.repo.CategoryDao;
import com.amitd.homeservicesandcleaningservicesportal.beans.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public Category save(Category p) {
        return categoryDao.save(p);
    }

    public List<Category> show() {
        return categoryDao.findAll();
    }

    public Optional<Category> findCategory(int id) {
        return categoryDao.findById(id);
    }

    public void delete(int id) {
        categoryDao.deleteById(id);
    }

    public void multiDelete(List<Integer> id) {
        categoryDao.deleteAllById(id);
    }

    public Category update(Category u) {
        return categoryDao.save(u);
    }

    public List<Category> searchBetweenDays(String s1, String e1) {
        return categoryDao.betweenDate(s1, e1);
    }

    public Category findCategoryName(String name) {
        return categoryDao.findByName(name);
    }

}
