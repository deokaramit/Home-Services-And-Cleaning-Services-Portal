package com.amitd.homeservicesandcleaningservicesportal.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.amitd.homeservicesandcleaningservicesportal.dto.RoleDto;
import com.amitd.homeservicesandcleaningservicesportal.beans.Role;
import com.amitd.homeservicesandcleaningservicesportal.service.RoleService;

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
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("")
    public ResponseEntity<?> addRole(@Valid @RequestBody RoleDto u) {
        Role u1 = RoleDto.toEntity(u);
        // System.out.println(Calendar.getInstance().getTime());
        u1.setCreated_at(Calendar.getInstance().getTime());
        Role newRole = roleService.save(u1);
        RoleDto newDto = RoleDto.fromEntity(newRole);
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("data", newDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<Role>> RoleList() {
        List<Role> list = roleService.show();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findRole(@PathVariable int id) {
        Optional<Role> p = roleService.findRole(id);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable int id) {
        roleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Multiple Delete
    @PostMapping("/destroyMultiple")
    public ResponseEntity<?> deleteMultiRole(@RequestBody List<Integer> id) {
        roleService.multiDelete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Select between two dates
    @GetMapping("/search_between")
    public ResponseEntity<?> betweenDates(
            @RequestParam(name = "sdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate s,
            @RequestParam(name = "edate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate e) {

        return ResponseEntity.ok(roleService.searchBetweenDays(s.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                e.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable int id, @Valid @RequestBody RoleDto r) {

        // System.out.println(r);

        Role r1 = RoleDto.toEntity(r);
        r1.setUpdated_at(Calendar.getInstance().getTime());
        Role newRole = roleService.update(r1);

        // Message
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("status", newRole);
        return ResponseEntity.ok(result);
    }
}
