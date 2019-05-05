package com.fa.factory.configuration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.factory.admin.dto.UserDto;
import com.fa.factory.admin.interfaces.AdminClient;
import com.fa.factory.common.exceptions.FactoryException;
import com.fa.factory.common.models.ApiResponse;
import com.fa.factory.configuration.service.UserDataService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private AdminClient userClient;

    public UserDto createUser(Long id, String firstName, String lastName) throws FactoryException {
        // check existed user
        ApiResponse<UserDto> oldUserResponse = userClient.getUserById(id);
        UserDto oldUser = oldUserResponse.getData();
        if (oldUser == null) {
            //create new user
            oldUser = new UserDto();
            oldUser.setFirstName(firstName);
            oldUser.setLastName(lastName);
            ApiResponse<UserDto> newUserReponse = userClient.saveUser(oldUser);
            oldUser = newUserReponse.getData();
        }
        // you can update user here if existed user
        return oldUser;

    }

}
