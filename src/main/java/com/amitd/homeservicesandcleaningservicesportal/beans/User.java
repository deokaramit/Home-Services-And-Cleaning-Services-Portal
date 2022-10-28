package com.amitd.homeservicesandcleaningservicesportal.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String username;

        private String email;

        private String password;

        private String description;

        private Date dob;

        @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
        @JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
                        @JoinColumn(name = "role_id") })
        private Set<Role> roles = new HashSet<>();

        // @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
        // @JoinTable(name = "users_works", joinColumns = { @JoinColumn(name =
        // "user_id") }, inverseJoinColumns = {
        // @JoinColumn(name = "work_id") })
        // private Set<Work> works = new HashSet<>();

        // @OneToOne(fetch = FetchType.LAZY, mappedBy = "worker", targetEntity =
        // Booking.class)
        // private Booking bookings;

        // @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", targetEntity =
        // Booking.class)
        // private Booking orders;

        // @OneToMany(fetch = FetchType.LAZY, mappedBy = "worker", targetEntity =
        // Rating.class)
        // private List<Rating> ratings;

        // @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", targetEntity =
        // Rating.class)
        // private List<Rating> reviews;

        // @OneToMany(fetch = FetchType.LAZY, mappedBy = "worker_order", targetEntity =
        // WorkProgress.class)
        // private List<WorkProgress> worker_order;

        // @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer_booking",
        // targetEntity = WorkProgress.class)
        // private List<WorkProgress> customer_booking;

        private int workexperiance;

        private String city;

        private int aadharno;

        @Temporal(TemporalType.TIMESTAMP)
        private Date created_at;

        @Temporal(TemporalType.TIMESTAMP)
        private Date updated_at;

        /**
         * @param id
         */
        public User(int id) {
                this.id = id;
        }

}
