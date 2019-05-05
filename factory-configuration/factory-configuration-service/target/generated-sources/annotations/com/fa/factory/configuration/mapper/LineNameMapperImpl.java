package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.LineNameDTO;
import com.fa.factory.configuration.model.Line;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class LineNameMapperImpl implements LineNameMapper {

    @Override
    public LineNameDTO entityToDTO(Line line) {
        if (line == null) {
            return null;
        }

        LineNameDTO lineNameDTO = new LineNameDTO();

        lineNameDTO.setId(line.getId());
        lineNameDTO.setLineName(line.getLineName());

        return lineNameDTO;
    }

    @Override
    public Line dtoToEntity(LineNameDTO lineName) {
        if (lineName == null) {
            return null;
        }

        Line line = new Line();

        if (lineName.getId() != null) {
            line.setId(lineName.getId());
        }
        line.setLineName(lineName.getLineName());

        return line;
    }
}
