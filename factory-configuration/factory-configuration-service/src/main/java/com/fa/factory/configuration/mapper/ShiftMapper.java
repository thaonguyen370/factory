package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.ShiftDTO;
import com.fa.factory.configuration.model.Shift;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ShiftMapper {

    Shift ShiftDTOToShift(ShiftDTO shiftDTO);

    ShiftDTO ShiftToShiftDTO(Shift shift);

}
