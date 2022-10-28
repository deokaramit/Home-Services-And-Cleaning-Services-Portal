package com.amitd.homeservicesandcleaningservicesportal.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.amitd.homeservicesandcleaningservicesportal.dto.CategoryDto;
import com.amitd.homeservicesandcleaningservicesportal.beans.Category;
import com.amitd.homeservicesandcleaningservicesportal.service.CategoryService;

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
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<?> addRole(@Valid @RequestBody CategoryDto c) {
        Category c1 = CategoryDto.toEntity(c);

        c1.setCreated_at(Calendar.getInstance().getTime());
        Category newCategory = categoryService.save(c1);
        CategoryDto newDto = CategoryDto.fromEntity(newCategory);
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("data", newDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> CategoryList() {
        List<Category> list = categoryService.show();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCategory(@PathVariable int id) {
        Optional<Category> p = categoryService.findCategory(id);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Multiple Delete
    @PostMapping("/destroyMultiple")
    public ResponseEntity<?> deleteMultiCategory(@RequestBody List<Integer> id) {
        categoryService.multiDelete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Select between two dates
    @GetMapping("/search_between")
    public ResponseEntity<?> betweenDates(
            @RequestParam(name = "sdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate s,
            @RequestParam(name = "edate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate e) {

        return ResponseEntity.ok(categoryService.searchBetweenDays(s.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                e.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @Valid @RequestBody CategoryDto r) {

        // System.out.println(r);

        Category c1 = CategoryDto.toEntity(r);
        c1.setUpdated_at(Calendar.getInstance().getTime());
        Category newCategory = categoryService.update(c1);

        // Message
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("status", newCategory);
        return ResponseEntity.ok(result);
    }
}
