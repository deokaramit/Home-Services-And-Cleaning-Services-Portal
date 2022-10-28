package com.amitd.homeservicesandcleaningservicesportal.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.amitd.homeservicesandcleaningservicesportal.dto.WorkDto;
import com.amitd.homeservicesandcleaningservicesportal.beans.Work;
import com.amitd.homeservicesandcleaningservicesportal.service.WorkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/works")
public class WorkController {
    @Autowired
    private WorkService workService;

    @PostMapping("")
    public ResponseEntity<?> addWork(@Valid @RequestBody WorkDto w) {
        Work w1 = WorkDto.toEntity(w);

        w1.setCreated_at(Calendar.getInstance().getTime());

        Work newWork = workService.save(w1);
        WorkDto newDto = WorkDto.fromEntity(newWork);
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("data", newDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{id}/user")
    public ResponseEntity<?> addWorkToUser(@RequestBody WorkDto workDto) {

        Work work = WorkDto.toEntity(workDto);

        work.setCreated_at(Calendar.getInstance().getTime());

        Work newWork = workService.save(work);

        WorkDto newDto = WorkDto.fromEntity(newWork);

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("data", newDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<Work>> WorksList() {
        List<Work> list = workService.show();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findWorks(@PathVariable int id) {
        Optional<Work> w = workService.findWork(id);
        return ResponseEntity.ok(w);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorks(@PathVariable int id) {
        workService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Multiple Delete
    @PostMapping("/destroyMultiple")
    public ResponseEntity<?> deleteMultiWorks(@RequestBody List<Integer> id) {
        workService.multiDelete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Select between two dates
    @GetMapping("/search_between")
    public ResponseEntity<?> betweenDates(
            @RequestParam(name = "sdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate s,
            @RequestParam(name = "edate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate e) {

        return ResponseEntity.ok(workService.searchBetweenDays(s.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                e.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWorks(@PathVariable int id, @Valid @RequestBody WorkDto w) {
        Work w1 = WorkDto.toEntity(w);
        w1.setUpdated_at(Calendar.getInstance().getTime());
        Work newWorks = workService.update(w1);

        // Message
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("status", newWorks);
        return ResponseEntity.ok(result);
    }
}
