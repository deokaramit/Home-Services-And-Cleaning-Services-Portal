package com.amitd.homeservicesandcleaningservicesportal.repo;

import java.util.List;

import com.amitd.homeservicesandcleaningservicesportal.beans.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT * FROM categories WHERE name = ?", nativeQuery = true)
    Category findByName(String name);

    @Query(value = "SELECT * FROM categories WHERE created_at BETWEEN ? AND ? ", nativeQuery = true)
    List<Category> betweenDate(String s1, String e1);
}
