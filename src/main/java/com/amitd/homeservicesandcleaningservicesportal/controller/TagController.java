package com.amitd.homeservicesandcleaningservicesportal.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.amitd.homeservicesandcleaningservicesportal.dto.TagDto;
import com.amitd.homeservicesandcleaningservicesportal.beans.Tag;
import com.amitd.homeservicesandcleaningservicesportal.service.TagService;

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
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("")
    public ResponseEntity<?> addTag(@Valid @RequestBody TagDto c) {
        Tag t1 = TagDto.toEntity(c);

        System.out.println(c);

        t1.setCreated_at(Calendar.getInstance().getTime());
        Tag newTag = tagService.save(t1);
        TagDto newDto = TagDto.fromEntity(newTag);
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("data", newDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<Tag>> TagsList() {
        List<Tag> list = tagService.show();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTags(@PathVariable int id) {
        Optional<Tag> t = tagService.findTag(id);
        return ResponseEntity.ok(t);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTags(@PathVariable int id) {
        tagService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Multiple Delete
    @PostMapping("/destroyMultiple")
    public ResponseEntity<?> deleteMultiTags(@RequestBody List<Integer> id) {
        tagService.multiDelete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTags(@PathVariable int id, @Valid @RequestBody TagDto t) {
        Tag t1 = TagDto.toEntity(t);
        t1.setUpdated_at(Calendar.getInstance().getTime());
        Tag newTag = tagService.update(t1);

        // Message
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status", "success");
        result.put("status", newTag);
        return ResponseEntity.ok(result);
    }
}
