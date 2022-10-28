package com.amitd.homeservicesandcleaningservicesportal.dto;

import com.amitd.homeservicesandcleaningservicesportal.beans.Category;
import com.amitd.homeservicesandcleaningservicesportal.beans.Tag;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TagDto {

    private int id;

    private String name;

    private Category category;

    public TagDto(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static TagDto fromEntity(Tag c) {
        TagDto dto = new TagDto();
        BeanUtils.copyProperties(c, dto);
        dto.setId(c.getId());
        return dto;
    }

    // called from POST, PUT
    public static Tag toEntity(TagDto dto) {
        Tag c = new Tag();
        BeanUtils.copyProperties(dto, c);
        c.setId(dto.getId());
        return c;
    }
}
