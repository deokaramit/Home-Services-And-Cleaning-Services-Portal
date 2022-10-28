package com.amitd.homeservicesandcleaningservicesportal.dto;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.amitd.homeservicesandcleaningservicesportal.beans.Role;
import com.amitd.homeservicesandcleaningservicesportal.beans.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private int id;

    private String username;

    private String email;

    private String description;

    private Set<Role> roles;

    private String password;

    private int workexperiance;

    private String city;

    private int aadharno;

    private Date created_at;

    private Date updated_at;

    public UserDto(String username, String email, String description, Set<Role> roles, String password) {
        this.username = username;
        this.email = email;
        this.description = description;
        this.roles = roles;
        this.password = password;
    }

    /**
     * @param username
     * @param email
     * @param description
     * @param roles
     * @param password
     * @param workexperiance
     * @param city
     * @param aadharno
     */
    public UserDto(String username, String email, String description, Set<Role> roles, String password,
            int workexperiance, String city, int aadharno) {
        this.username = username;
        this.email = email;
        this.description = description;
        this.roles = roles;
        this.password = password;
        this.workexperiance = workexperiance;
        this.city = city;
        this.aadharno = aadharno;
    }

    public UserDto(String username, String email, String password, String description) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
    }

    public UserDto(int id, String username, String email, String password, String description) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
    }

    public static UserDto fromEntity(User b) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(b, dto);
        dto.setId(b.getId());
        return dto;
    }

    // called from POST, PUT
    public static User toEntity(UserDto dto) {
        User u = new User();
        BeanUtils.copyProperties(dto, u);
        u.setId(dto.getId());
        return u;
    }

}
