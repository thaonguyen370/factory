package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.BreakTimeDTO;
import com.fa.factory.configuration.model.BreakTime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BreakTimeMapper {

    BreakTimeDTO breakTimeToBreakTimeDTO(BreakTime breakTime);

    BreakTime breakTimeDTOToBreakTime(BreakTimeDTO breakTimeDTO);

}
