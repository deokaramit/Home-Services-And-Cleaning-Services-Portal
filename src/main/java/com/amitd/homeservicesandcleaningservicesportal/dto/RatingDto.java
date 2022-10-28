package com.amitd.homeservicesandcleaningservicesportal.dto;

import java.util.Date;

import com.amitd.homeservicesandcleaningservicesportal.beans.Rating;
import com.amitd.homeservicesandcleaningservicesportal.beans.User;
import com.amitd.homeservicesandcleaningservicesportal.beans.Work;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class RatingDto {
    private int id;

    private int stars;

    private String comments;

    private User worker;

    private User customer;

    private Work booking;

    private Date created_at;

    private Date updated_at;

    public RatingDto(int id, int stars, String comments, User worker, User customer) {
        this.id = id;
        this.stars = stars;
        this.comments = comments;
        this.worker = worker;
        this.customer = customer;
    }

    public RatingDto(int id, int stars, String comments, Work booking) {
        this.id = id;
        this.stars = stars;
        this.comments = comments;
        this.booking = booking;
    }

    public static RatingDto fromEntity(Rating c) {
        RatingDto dto = new RatingDto();
        BeanUtils.copyProperties(c, dto);
        dto.setId(c.getId());
        return dto;
    }

    // called from POST, PUT
    public static Rating toEntity(RatingDto dto) {
        Rating c = new Rating();
        BeanUtils.copyProperties(dto, c);
        c.setId(dto.getId());
        return c;
    }
}
