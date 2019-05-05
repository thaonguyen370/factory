package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.ShiftDTO;
import com.fa.factory.configuration.model.Shift;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class ShiftMapperImpl implements ShiftMapper {

    @Override
    public Shift ShiftDTOToShift(ShiftDTO shiftDTO) {
        if (shiftDTO == null) {
            return null;
        }

        Shift shift = new Shift();

        shift.setShiftId(shiftDTO.getShiftId());
        shift.setName(shiftDTO.getName());
        shift.setStartTime(shiftDTO.getStartTime());
        shift.setEndTime(shiftDTO.getEndTime());
        shift.setDayOfWeek(shiftDTO.getDayOfWeek());
        shift.setLineId(shiftDTO.getLineId());

        return shift;
    }

    @Override
    public ShiftDTO ShiftToShiftDTO(Shift shift) {
        if (shift == null) {
            return null;
        }

        ShiftDTO shiftDTO = new ShiftDTO();

        shiftDTO.setShiftId(shift.getShiftId());
        shiftDTO.setName(shift.getName());
        shiftDTO.setStartTime(shift.getStartTime());
        shiftDTO.setEndTime(shift.getEndTime());
        shiftDTO.setDayOfWeek(shift.getDayOfWeek());
        shiftDTO.setLineId(shift.getLineId());

        return shiftDTO;
    }
}
