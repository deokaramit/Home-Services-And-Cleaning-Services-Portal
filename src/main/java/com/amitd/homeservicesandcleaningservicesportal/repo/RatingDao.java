package com.amitd.homeservicesandcleaningservicesportal.repo;

import com.amitd.homeservicesandcleaningservicesportal.beans.Rating;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingDao extends JpaRepository<Rating, Integer> {

}
