package com.amitd.homeservicesandcleaningservicesportal.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitd.homeservicesandcleaningservicesportal.beans.Booking;
import com.amitd.homeservicesandcleaningservicesportal.dto.BookingDto;
import com.amitd.homeservicesandcleaningservicesportal.service.BookingService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("")
    public ResponseEntity<?> addBooking(@Valid @RequestBody BookingDto w) {
        Booking w1 = BookingDto.toEntity(w);

        w1.setCreated_at(Calendar.getInstance().getTime());

        Booking newBooking = bookingService.save(w1);
        BookingDto newDto = BookingDto.fromEntity(newBooking);
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("data", newDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<Booking>> BookingsList() {
        List<Booking> list = bookingService.show();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}/customer")
    public ResponseEntity<List<Booking>> BookingsCustomerList(@PathVariable int id) {
        List<Booking> list = bookingService.getCustomerBooking(id);
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBookings(@PathVariable int id) {
        Optional<Booking> w = bookingService.findBooking(id);
        return ResponseEntity.ok(w);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookings(@PathVariable int id) {
        bookingService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Multiple Delete
    @PostMapping("/destroyMultiple")
    public ResponseEntity<?> deleteMultiBookings(@RequestBody List<Integer> id) {
        bookingService.multiDelete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookings(@PathVariable int id, @Valid @RequestBody BookingDto w) {
        Booking w1 = BookingDto.toEntity(w);
        w1.setUpdated_at(Calendar.getInstance().getTime());
        Booking newBookings = bookingService.update(w1);

        // Message
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("status", newBookings);
        return ResponseEntity.ok(result);
    }
}
