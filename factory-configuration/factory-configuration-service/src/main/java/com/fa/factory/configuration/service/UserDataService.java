package com.fa.factory.configuration.service;

import com.fa.factory.admin.dto.UserDto;
import com.fa.factory.common.exceptions.FactoryException;

public interface UserDataService {
    UserDto createUser(Long id, String firstName, String lastName) throws FactoryException;

}
