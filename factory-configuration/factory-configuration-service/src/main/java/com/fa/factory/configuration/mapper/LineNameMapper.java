package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.LineNameDTO;
import com.fa.factory.configuration.model.Line;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface LineNameMapper {
    LineNameDTO entityToDTO(Line line);

    Line dtoToEntity(LineNameDTO lineName);
}
