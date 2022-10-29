package com.amitd.homeservicesandcleaningservicesportal.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.amitd.homeservicesandcleaningservicesportal.beans.User;
import com.amitd.homeservicesandcleaningservicesportal.dto.UserDto;
import com.amitd.homeservicesandcleaningservicesportal.mapper.UserMapper;
import com.amitd.homeservicesandcleaningservicesportal.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto) {
        User user = userMapper.dtoToModel(userDto);

        user.setCreated_at(Calendar.getInstance().getTime());

        user.getRoles().iterator().next().setCreated_at(Calendar.getInstance().getTime());
        ;

        userDto = UserDto.fromEntity(userService.save(user));

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("data", userDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> UserList() {
        List<User> list = userService.show();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}/worker")
    public ResponseEntity<List<User>> WorkerList(@PathVariable int id) {
        List<User> list = userService.findUserByWork(id);
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUser(@PathVariable int id) {
        User user = userService.findUser(id);
        return ResponseEntity.ok(user);
        // if (p != null) {
        // return ResponseEntity.ok(p);
        // } else {
        // return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        // }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Multiple Delete
    @PostMapping("/destroyMultiple")
    public ResponseEntity<?> deleteMultiUser(@RequestBody List<Integer> id) {
        userService.multiDelete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Select between two dates
    @GetMapping("/search_between")
    public ResponseEntity<?> betweenDates(
            @RequestParam(name = "sdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate s,
            @RequestParam(name = "edate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate e) {

        return ResponseEntity.ok(userService.searchBetweenDays(s.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                e.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @Valid @RequestBody UserDto u) {
        User u1 = UserDto.toEntity(u);
        u1.setUpdated_at(Calendar.getInstance().getTime());
        User newUser = userService.update(u1);

        // Message
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("status", newUser);
        return ResponseEntity.ok(result);
    }
}
