package com.fa.factory.configuration.controller;

import com.fa.factory.common.exceptions.FactoryException;
import com.fa.factory.common.models.ApiResponse;
import com.fa.factory.configuration.dto.BreakTimeDTO;
import com.fa.factory.configuration.dto.ShiftDTO;
import com.fa.factory.configuration.mapper.BreakTimeMapper;
import com.fa.factory.configuration.model.BreakTime;
import com.fa.factory.configuration.service.impl.ShiftServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "Shift")
@RestController
@Slf4j
public class ShiftController {

    @Autowired
    private ShiftServiceImpl shiftService;

    @Autowired
    private BreakTimeMapper breakTimeMapper;

    @ApiOperation(value = "Create Shift")
    @PostMapping("/shift")
    public ApiResponse<ShiftDTO> insert(@RequestBody ShiftDTO shiftDTO) {

        if (shiftDTO.getEndTime().compareTo(shiftDTO.getStartTime()) <= 0) {
            return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED, "End Time must greater Start Time of the Shift", new FactoryException());
        }

        if (!shiftService.validateTimeShiftInLine(shiftDTO)) {
            return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED, "Time of Shift is Overlapped with other Shift in Line", new FactoryException());
        }

        ShiftDTO shiftDTO_return = shiftService.createShift(shiftDTO);
        if (shiftDTO_return == null) return new ApiResponse<>(HttpStatus.BAD_REQUEST);

        if (shiftDTO.getBreakTimes() != null && !shiftDTO.getBreakTimes().isEmpty()) {

            List<BreakTime> breakTimeList = new ArrayList<>();
            boolean validateTime;

            for (BreakTimeDTO breakTimeDto : shiftDTO.getBreakTimes()) {
                validateTime = shiftService.validateTimeIsMid(shiftDTO.getStartTime(),
                        shiftDTO.getEndTime(),
                        breakTimeDto.getStartTime(),
                        breakTimeDto.getEndTime());
                if (!validateTime)
                    return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED, "Time in Break Time invalid with Time in Shift", new FactoryException());

                breakTimeDto.setShiftId(shiftDTO_return.getShiftId());
                breakTimeList.add(breakTimeMapper.breakTimeDTOToBreakTime(breakTimeDto));
            }
            List<BreakTimeDTO> breakTimeDTOList_return = shiftService.createListBreakTimes(breakTimeList);
            shiftDTO_return.setBreakTimes(breakTimeDTOList_return);
        }
        return ApiResponse.created(shiftDTO_return);
    }

    @GetMapping(value = "/getAllShift")
    public ApiResponse<List<ShiftDTO>> getAllShift() {
        List listShift = shiftService.getAllShift();
        return new ApiResponse<>(listShift, HttpStatus.OK);
    }

}
