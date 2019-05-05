package com.fa.factory.admin.service;

import com.fa.factory.admin.dto.UserDto;

import java.util.List;

public interface UserService {

    Boolean save(UserDto user);

    Boolean deleteByID(Integer id);

    Boolean checkUserExist(String userName);

    Boolean checkEmailExist(String userName);

    Boolean checkSsoExist(String userName);

    UserDto getUserByUsername(String username);

    List<UserDto> loadAllUser();

    UserDto findById(int id);
}
