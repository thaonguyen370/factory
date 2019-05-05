package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.LineDTO;
import com.fa.factory.configuration.dto.LinePausetimeDTO;
import com.fa.factory.configuration.dto.PausetimeDTO;
import com.fa.factory.configuration.model.Line;
import com.fa.factory.configuration.model.PauseTime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface LineMapper {
    LineDTO lineToLineDto(Line line);

    Line lineDtoToLine(LineDTO line);

    Line linePausetimeDtoToLine(LinePausetimeDTO linePausetimeDTO);

    PauseTime linePauseTimeDtoToPausetime(PausetimeDTO pausetimeDTO);
}
