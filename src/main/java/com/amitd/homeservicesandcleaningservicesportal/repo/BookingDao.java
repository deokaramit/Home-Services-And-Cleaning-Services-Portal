package com.amitd.homeservicesandcleaningservicesportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amitd.homeservicesandcleaningservicesportal.beans.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {

    @Query(value = "SELECT * FROM bookings b where b.customer = ?", nativeQuery = true)
    List<Booking> findCustomerBooking(int id);

}