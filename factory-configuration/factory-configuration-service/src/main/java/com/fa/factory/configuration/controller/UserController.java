package com.fa.factory.configuration.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fa.factory.common.exceptions.FactoryException;
import com.fa.factory.common.models.ApiResponse;
import com.fa.factory.configuration.model.UserRequest;
import com.fa.factory.configuration.service.UserDataService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserDataService userDataService;

    @ApiOperation(value = "factory")
    @PostMapping("/user")
    public ApiResponse<Boolean> createUser(@RequestBody UserRequest request) throws IOException, FactoryException {
        userDataService.createUser(request.getId(), request.getFirstName(), request.getLastName());
        return new ApiResponse<>(HttpStatus.OK);
    }

    @GetMapping("/user")
    public ApiResponse<Boolean> getUser() {
        return new ApiResponse<>(HttpStatus.OK);
    }
}
