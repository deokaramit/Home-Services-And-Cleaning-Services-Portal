package com.amitd.homeservicesandcleaningservicesportal.dto;

import com.amitd.homeservicesandcleaningservicesportal.beans.Role;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class RoleDto {

    private int id;

    private String name;

    public RoleDto(String name) {
        this.name = name;
    }

    public static RoleDto fromEntity(Role r) {
        RoleDto dto = new RoleDto();
        BeanUtils.copyProperties(r, dto);
        dto.setId(r.getId());
        return dto;
    }

    // called from POST, PUT
    public static Role toEntity(RoleDto dto) {
        Role r = new Role();
        BeanUtils.copyProperties(dto, r);
        r.setId(dto.getId());
        return r;
    }
}
