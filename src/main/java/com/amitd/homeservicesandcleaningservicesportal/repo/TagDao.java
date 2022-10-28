package com.amitd.homeservicesandcleaningservicesportal.repo;

import java.util.List;

import com.amitd.homeservicesandcleaningservicesportal.beans.Role;
import com.amitd.homeservicesandcleaningservicesportal.beans.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagDao extends JpaRepository<Tag, Integer> {

    Role findByName(String name);

    @Query(value = "SELECT * FROM tags WHERE created_at BETWEEN ? AND ? ", nativeQuery = true)
    List<Tag> betweenDate(String s1, String e1);
}
