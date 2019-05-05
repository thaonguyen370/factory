package com.fa.factory.admin.interfaces;

import com.fa.factory.admin.dto.RoleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fa.factory.admin.config.AdminFeignConfiguration;
import com.fa.factory.admin.dto.UserDto;
import com.fa.factory.common.models.ApiResponse;


@FeignClient(name = "factory-admin", configuration = AdminFeignConfiguration.class)
public interface AdminClient {

    @GetMapping(value = "/user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<UserDto> getUserById(@PathVariable(name = "id") Long id);

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<UserDto> saveUser(@RequestBody UserDto userDto);

    @GetMapping(value = "/user/username={username}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<UserDto> findUserByUsername(@PathVariable(name = "username") String username);

    @GetMapping(value = "/role/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<RoleDto> findRoleById(@PathVariable(name = "id") int id);
}
