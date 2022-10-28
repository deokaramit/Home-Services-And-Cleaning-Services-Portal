package com.amitd.homeservicesandcleaningservicesportal.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date book_date;

    private double amount;

    // @JsonIgnore
    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "worker_id", referencedColumnName = "id")
    // private User worker;

    // @OneToOne(cascade = CascadeType.MERGE)
    // @JoinColumn(name = "customer_id", referencedColumnName = "id")
    // private User customer;

    // @OneToOne(cascade = CascadeType.MERGE)
    // @JoinColumn(name = "work_id", referencedColumnName = "id")
    // private Work work;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

}
