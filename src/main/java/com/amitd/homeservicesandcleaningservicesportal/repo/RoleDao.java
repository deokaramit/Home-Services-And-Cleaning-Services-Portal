package com.amitd.homeservicesandcleaningservicesportal.repo;

import java.util.List;

import com.amitd.homeservicesandcleaningservicesportal.beans.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleDao extends JpaRepository<Role, Integer> {

    Role findByName(String name);

    @Query(value = "SELECT * FROM roles WHERE created_at BETWEEN ? AND ? ", nativeQuery = true)
    List<Role> betweenDate(String s1, String e1);
}
