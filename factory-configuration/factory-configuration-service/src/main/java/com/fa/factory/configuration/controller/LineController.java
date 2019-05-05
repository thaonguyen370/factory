package com.fa.factory.configuration.controller;

import com.fa.factory.common.exceptions.FactoryException;
import com.fa.factory.common.models.ApiResponse;
import com.fa.factory.configuration.dto.LineDTO;
import com.fa.factory.configuration.dto.LinePausetimeDTO;
import com.fa.factory.configuration.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LineController {
    @Autowired
    private LineService lineService;

    @GetMapping(value = "/lines")
    public ApiResponse<List<LineDTO>> getAllLine() {
        return new ApiResponse<>(lineService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/lines/{id}")
    public ApiResponse<List> getAllLineName(@PathVariable long id) throws FactoryException {
        List listName = lineService.getAllLineName(id);
        return new ApiResponse<>(listName, HttpStatus.OK);
    }

    @PostMapping(value = "/createLine")
    public ApiResponse<Boolean> save(@RequestBody LinePausetimeDTO linePausetimeDTO) {
        if (lineService.CheckDate(linePausetimeDTO.getPausetimeDTO())) {
            lineService.save(linePausetimeDTO);
            return new ApiResponse<>(HttpStatus.OK);
        } else return new ApiResponse<>(HttpStatus.BAD_REQUEST);
    }
}
