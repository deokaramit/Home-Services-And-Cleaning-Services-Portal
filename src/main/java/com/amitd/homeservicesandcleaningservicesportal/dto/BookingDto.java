package com.amitd.homeservicesandcleaningservicesportal.dto;

import java.util.Date;

import com.amitd.homeservicesandcleaningservicesportal.beans.Booking;
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

public class BookingDto {
    private int id;

    private Date book_date;

    private double amount;

    private User worker;

    private User customer;

    private Work work;

    private Date created_at;

    private Date updated_at;

    public BookingDto(Date book_date, double amount, User worker, User customer, Work work, Date created_at,
            Date updated_at) {
        this.book_date = book_date;
        this.amount = amount;
        this.worker = worker;
        this.customer = customer;
        this.work = work;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static BookingDto fromEntity(Booking c) {
        BookingDto dto = new BookingDto();
        BeanUtils.copyProperties(c, dto);
        dto.setId(c.getId());
        return dto;
    }

    // called from POST, PUT
    public static Booking toEntity(BookingDto dto) {
        Booking c = new Booking();
        BeanUtils.copyProperties(dto, c);
        c.setId(dto.getId());
        return c;
    }
}
