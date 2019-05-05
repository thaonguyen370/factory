package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.BreakTimeDTO;
import com.fa.factory.configuration.model.BreakTime;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class BreakTimeMapperImpl implements BreakTimeMapper {

    @Override
    public BreakTimeDTO breakTimeToBreakTimeDTO(BreakTime breakTime) {
        if (breakTime == null) {
            return null;
        }

        BreakTimeDTO breakTimeDTO = new BreakTimeDTO();

        breakTimeDTO.setBreakTimeId(breakTime.getBreakTimeId());
        breakTimeDTO.setName(breakTime.getName());
        breakTimeDTO.setStartTime(breakTime.getStartTime());
        breakTimeDTO.setEndTime(breakTime.getEndTime());
        breakTimeDTO.setShiftId(breakTime.getShiftId());

        return breakTimeDTO;
    }

    @Override
    public BreakTime breakTimeDTOToBreakTime(BreakTimeDTO breakTimeDTO) {
        if (breakTimeDTO == null) {
            return null;
        }

        BreakTime breakTime = new BreakTime();

        breakTime.setBreakTimeId(breakTimeDTO.getBreakTimeId());
        breakTime.setName(breakTimeDTO.getName());
        breakTime.setStartTime(breakTimeDTO.getStartTime());
        breakTime.setEndTime(breakTimeDTO.getEndTime());
        breakTime.setShiftId(breakTimeDTO.getShiftId());

        return breakTime;
    }
}
