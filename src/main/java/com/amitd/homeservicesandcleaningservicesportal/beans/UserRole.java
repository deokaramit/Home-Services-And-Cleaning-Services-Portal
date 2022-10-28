package com.amitd.homeservicesandcleaningservicesportal.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// @Entity
// @Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Set<User> users;

    @ManyToOne(cascade = CascadeType.ALL)
    private Set<Role> roles;

}
