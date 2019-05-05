package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.LineDTO;
import com.fa.factory.configuration.dto.LinePausetimeDTO;
import com.fa.factory.configuration.dto.PausetimeDTO;
import com.fa.factory.configuration.model.Line;
import com.fa.factory.configuration.model.PauseTime;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class LineMapperImpl implements LineMapper {

    @Override
    public LineDTO lineToLineDto(Line line) {
        if (line == null) {
            return null;
        }

        LineDTO lineDTO = new LineDTO();

        lineDTO.setId(line.getId());
        lineDTO.setLineName(line.getLineName());
        lineDTO.setLineManager(line.getLineManager());
        lineDTO.setFactoryId(line.getFactoryId());
        lineDTO.setTaktTime(line.getTaktTime());
        lineDTO.setTargetOutput(line.getTargetOutput());
        lineDTO.setTargetFrequency(line.getTargetFrequency());

        return lineDTO;
    }

    @Override
    public Line lineDtoToLine(LineDTO line) {
        if (line == null) {
            return null;
        }

        Line line1 = new Line();

        line1.setId(line.getId());
        line1.setLineName(line.getLineName());
        line1.setLineManager(line.getLineManager());
        line1.setTaktTime(line.getTaktTime());
        line1.setTargetOutput(line.getTargetOutput());
        line1.setTargetFrequency(line.getTargetFrequency());
        line1.setFactoryId(line.getFactoryId());

        return line1;
    }

    @Override
    public Line linePausetimeDtoToLine(LinePausetimeDTO linePausetimeDTO) {
        if (linePausetimeDTO == null) {
            return null;
        }

        Line line = new Line();

        line.setId(linePausetimeDTO.getId());
        line.setLineName(linePausetimeDTO.getLineName());
        line.setLineManager(linePausetimeDTO.getLineManager());
        line.setStartTime(linePausetimeDTO.getStartTime());
        line.setTaktTime(linePausetimeDTO.getTaktTime());
        line.setTargetOutput(linePausetimeDTO.getTargetOutput());
        line.setTargetFrequency(linePausetimeDTO.getTargetFrequency());
        line.setFactoryId(linePausetimeDTO.getFactoryId());

        return line;
    }

    @Override
    public PauseTime linePauseTimeDtoToPausetime(PausetimeDTO pausetimeDTO) {
        if (pausetimeDTO == null) {
            return null;
        }

        PauseTime pauseTime = new PauseTime();

        pauseTime.setName(pausetimeDTO.getName());
        pauseTime.setStartTime(pausetimeDTO.getStartTime());
        pauseTime.setEndTime(pausetimeDTO.getEndTime());

        return pauseTime;
    }
}
