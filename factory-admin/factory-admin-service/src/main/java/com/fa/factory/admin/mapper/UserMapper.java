package com.fa.factory.admin.mapper;

import org.mapstruct.Mapper;
import com.fa.factory.admin.dto.UserDto;
import com.fa.factory.admin.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

}
