package com.amitd.homeservicesandcleaningservicesportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitd.homeservicesandcleaningservicesportal.beans.Booking;
import com.amitd.homeservicesandcleaningservicesportal.repo.BookingDao;

@Service
public class BookingService {

    @Autowired
    BookingDao bookingDao;

    public Booking save(Booking p) {
        return bookingDao.save(p);
    }

    public List<Booking> show() {
        return bookingDao.findAll();
    }

    public Optional<Booking> findBooking(int id) {
        return bookingDao.findById(id);
    }

    public void delete(int id) {
        bookingDao.deleteById(id);
    }

    public void multiDelete(List<Integer> id) {
        bookingDao.deleteAllById(id);
    }

    public Booking update(Booking u) {
        return bookingDao.save(u);
    }

    public List<Booking> getCustomerBooking(int id) {
        return bookingDao.findCustomerBooking(id);
    }

}
