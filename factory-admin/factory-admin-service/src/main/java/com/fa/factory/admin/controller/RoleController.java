package com.fa.factory.admin.controller;

import com.fa.factory.admin.dto.RoleDto;
import com.fa.factory.admin.model.Role;
import com.fa.factory.admin.service.RoleService;
import com.fa.factory.common.models.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@Api(tags = "Roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "Get all roles factory")
    @GetMapping(value = "/role/all")
    public ApiResponse<List<RoleDto>> getAllRole() {
        return new ApiResponse<>(roleService.findAllRole(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get role by id")
    @GetMapping(value = "/role/{id}")
    public ApiResponse<RoleDto> getRoleById(@PathVariable int id) {
        return new ApiResponse<>(roleService.findById(id), HttpStatus.OK);
    }

}
