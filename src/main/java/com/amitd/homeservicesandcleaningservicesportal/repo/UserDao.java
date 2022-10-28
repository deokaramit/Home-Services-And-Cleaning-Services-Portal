package com.amitd.homeservicesandcleaningservicesportal.repo;

import java.util.List;

import com.amitd.homeservicesandcleaningservicesportal.beans.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE created_at BETWEEN ? AND ? ", nativeQuery = true)
    List<User> betweenDate(String s1, String e1);

    @Query(value = "select u from User u inner join u.works w where w.id  = ?", nativeQuery = true)
    List<User> findUserByWork(int work_id);

}
