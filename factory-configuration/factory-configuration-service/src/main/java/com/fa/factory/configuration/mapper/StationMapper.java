package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.StationDTO;
import com.fa.factory.configuration.model.Station;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper {
    StationDTO entityToStationDto(Station station);

    Station stationDtoToEntity(StationDTO stationDTO);

}
