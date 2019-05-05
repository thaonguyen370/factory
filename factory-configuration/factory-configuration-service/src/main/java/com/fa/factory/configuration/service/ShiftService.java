package com.fa.factory.configuration.service;

import com.fa.factory.common.exceptions.FactoryException;
import com.fa.factory.configuration.dto.BreakTimeDTO;
import com.fa.factory.configuration.dto.ShiftDTO;
import com.fa.factory.configuration.model.BreakTime;
import com.fa.factory.configuration.model.Shift;

import java.util.List;

public interface ShiftService {

    ShiftDTO createShift(ShiftDTO shiftDTO);

    List<BreakTimeDTO> createListBreakTimes(List<BreakTime> list);

    List getAllShift() throws FactoryException;

    ShiftDTO convertShiftToShiftDTO(Shift shift);

}
