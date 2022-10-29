package com.amitd.homeservicesandcleaningservicesportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.amitd.homeservicesandcleaningservicesportal.beans.User;
import com.amitd.homeservicesandcleaningservicesportal.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        UserDto modelToDto(User user);
        User dtoToModel(UserDto userDto);
}
