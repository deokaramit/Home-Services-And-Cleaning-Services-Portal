package com.amitd.homeservicesandcleaningservicesportal.dto;

import java.util.Set;

import com.amitd.homeservicesandcleaningservicesportal.beans.Category;
import com.amitd.homeservicesandcleaningservicesportal.beans.Tag;
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

public class CategoryDto {

    private int id;

    private String name;

    private Set<Work> works;

    private Set<Tag> tags;

    public CategoryDto(String name) {
        this.name = name;
    }

    public static CategoryDto fromEntity(Category c) {
        CategoryDto dto = new CategoryDto();
        BeanUtils.copyProperties(c, dto);
        dto.setId(c.getId());
        return dto;
    }

    // called from POST, PUT
    public static Category toEntity(CategoryDto dto) {
        Category c = new Category();
        BeanUtils.copyProperties(dto, c);
        c.setId(dto.getId());
        return c;
    }
}
