package com.amitd.homeservicesandcleaningservicesportal.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.amitd.homeservicesandcleaningservicesportal.dto.RatingDto;
import com.amitd.homeservicesandcleaningservicesportal.beans.Rating;
import com.amitd.homeservicesandcleaningservicesportal.service.RatingService;

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

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("")
    public ResponseEntity<?> addRole(@Valid @RequestBody RatingDto w) {
        Rating w1 = RatingDto.toEntity(w);

        w1.setCreated_at(Calendar.getInstance().getTime());

        Rating newRating = ratingService.save(w1);
        RatingDto newDto = RatingDto.fromEntity(newRating);
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("data", newDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<Rating>> RatingsList() {
        List<Rating> list = ratingService.show();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findRatings(@PathVariable int id) {
        Optional<Rating> w = ratingService.findRating(id);
        return ResponseEntity.ok(w);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRatings(@PathVariable int id) {
        ratingService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Multiple Delete
    @PostMapping("/destroyMultiple")
    public ResponseEntity<?> deleteMultiRatings(@RequestBody List<Integer> id) {
        ratingService.multiDelete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRatings(@PathVariable int id, @Valid @RequestBody RatingDto w) {
        Rating w1 = RatingDto.toEntity(w);
        w1.setUpdated_at(Calendar.getInstance().getTime());
        Rating newRatings = ratingService.update(w1);

        // Message
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("status", newRatings);
        return ResponseEntity.ok(result);
    }
}
