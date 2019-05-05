package com.fa.factory.configuration.controller;

import com.fa.factory.common.exceptions.FactoryException;
import com.fa.factory.common.models.ApiResponse;
import com.fa.factory.configuration.dto.StationDTO;
import com.fa.factory.configuration.mapper.StationMapper;
import com.fa.factory.configuration.service.impl.StationServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationController {
    @Autowired
    private StationServiceImpl stationService;
    @Autowired
    private StationMapper mapper;

    @PostMapping("/station")
    public ApiResponse createStation(@RequestBody StationDTO stationDTO) {
        if (stationService.validatePosition(stationDTO))
            return new ApiResponse(HttpStatus.BAD_REQUEST,
                    "Target position has been selected by other station in line",
                    new FactoryException());
        stationService.createStation(stationDTO);
        return new ApiResponse(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all stations")
    @GetMapping(value = "/stations")
    public ApiResponse<List<StationDTO>> getAllStation() {
        List<StationDTO> stationList = stationService.getAllStations();
        return new ApiResponse<>(stationList, HttpStatus.OK);
    }

}
