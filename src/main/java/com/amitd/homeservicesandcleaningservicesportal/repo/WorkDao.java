package com.amitd.homeservicesandcleaningservicesportal.repo;

import java.util.List;

import com.amitd.homeservicesandcleaningservicesportal.beans.Role;
import com.amitd.homeservicesandcleaningservicesportal.beans.Work;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkDao extends JpaRepository<Work, Integer> {

    Role findByName(String name);

    @Query(value = "SELECT * FROM works WHERE created_at BETWEEN ? AND ? ", nativeQuery = true)
    List<Work> betweenDate(String s1, String e1);
}
