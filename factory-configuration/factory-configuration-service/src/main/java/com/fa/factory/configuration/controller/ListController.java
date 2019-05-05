package com.fa.factory.configuration.controller;

import com.fa.factory.configuration.dto.ListDTO;
import com.fa.factory.configuration.mapper.ListMapper;
import com.fa.factory.configuration.service.ListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import com.fa.factory.common.models.ApiResponse;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListController {
    @Autowired
    private ListService listService;
    @Autowired
    ListMapper listMapper;

    @ApiOperation(value = "Create API List")
    @GetMapping("/factory/all")
    public ApiResponse<List<ListDTO>> getAllList() {
        return new ApiResponse<>(listService.getAllList(), HttpStatus.OK);
    }
}
