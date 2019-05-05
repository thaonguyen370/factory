package com.fa.factory.admin.controller;

import com.fa.factory.admin.dto.UserDto;
import com.fa.factory.common.exceptions.FactoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.fa.factory.admin.service.UserService;
import com.fa.factory.common.models.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(tags = "User")
@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "delete user")
    @DeleteMapping("/user/delete/{id}")
    public ApiResponse deleteUser(@PathVariable Integer id) {
        if (userService.deleteByID(id)) {
            return new ApiResponse(HttpStatus.OK, "Success", new FactoryException());
        }
        return new ApiResponse(HttpStatus.BAD_REQUEST, "User is not exist", new FactoryException());
    }

    @ApiOperation(value = "Get All User")
    @GetMapping(value = "user/all")
    public ApiResponse<List<UserDto>> getAllUser() {
        return new ApiResponse<>(userService.loadAllUser(), HttpStatus.OK);
    }

    @ApiOperation(value = "Save user")
    @PostMapping(value = "/user/register")
    public ApiResponse<Boolean> saveUser(@RequestBody UserDto userDTO) {
        if (userService.save(userDTO)) {
            return new ApiResponse<>(true, HttpStatus.CREATED);
        } else {
            return new ApiResponse<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Get user by username")
    @GetMapping(value = "/user/username={username}")
    public ApiResponse<UserDto> getUserByUsername(@PathVariable String username) {
        return new ApiResponse<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @ApiOperation(value = "check email")
    @GetMapping(value = "/user/check-email={email}")
    public ApiResponse<Boolean> checkEmail(@PathVariable String email) {
        if (userService.checkEmailExist(email)) {
            return new ApiResponse<>(true, HttpStatus.OK);
        } else {
            return new ApiResponse<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "check sso")
    @GetMapping(value = "/user/check-sso={sso}")
    public ApiResponse<Boolean> checkSso(@PathVariable String sso) {
        if (userService.checkSsoExist(sso)) {
            return new ApiResponse<>(true, HttpStatus.OK);
        } else {
            return new ApiResponse<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "get user by id")
    @GetMapping(value = "/user/{id}")
    public ApiResponse<UserDto> findById(@PathVariable String id) {
        return new ApiResponse<>(userService.findById(Integer.parseInt(id)), HttpStatus.OK);
    }
}
