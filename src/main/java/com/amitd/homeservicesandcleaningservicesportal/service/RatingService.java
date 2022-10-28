package com.amitd.homeservicesandcleaningservicesportal.service;

import java.util.List;
import java.util.Optional;

import com.amitd.homeservicesandcleaningservicesportal.repo.RatingDao;
import com.amitd.homeservicesandcleaningservicesportal.beans.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    RatingDao bookingDao;

    public Rating save(Rating p) {
        return bookingDao.save(p);
    }

    public List<Rating> show() {
        return bookingDao.findAll();
    }

    public Optional<Rating> findRating(int id) {
        return bookingDao.findById(id);
    }

    public void delete(int id) {
        bookingDao.deleteById(id);
    }

    public void multiDelete(List<Integer> id) {
        bookingDao.deleteAllById(id);
    }

    public Rating update(Rating u) {
        return bookingDao.save(u);
    }

}
