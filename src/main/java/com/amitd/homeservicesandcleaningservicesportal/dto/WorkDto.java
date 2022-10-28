package com.amitd.homeservicesandcleaningservicesportal.dto;

import java.util.HashSet;
import java.util.Set;

import com.amitd.homeservicesandcleaningservicesportal.beans.Category;
import com.amitd.homeservicesandcleaningservicesportal.beans.User;
import com.amitd.homeservicesandcleaningservicesportal.beans.Work;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class WorkDto {

    private int id;

    private String name;

    private Category category;

    private Set<User> users = new HashSet<>();

    public WorkDto(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    /**
     * @param name
     * @param users
     */
    public WorkDto(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    public static WorkDto fromEntity(Work c) {
        WorkDto dto = new WorkDto();
        BeanUtils.copyProperties(c, dto);
        dto.setId(c.getId());
        return dto;
    }

    // called from POST, PUT
    public static Work toEntity(WorkDto dto) {
        Work c = new Work();
        BeanUtils.copyProperties(dto, c);
        c.setId(dto.getId());
        return c;
    }

}
