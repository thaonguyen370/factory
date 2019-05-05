package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.StationDTO;
import com.fa.factory.configuration.model.Station;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class StationMapperImpl implements StationMapper {

    @Override
    public StationDTO entityToStationDto(Station station) {
        if (station == null) {
            return null;
        }

        StationDTO stationDTO = new StationDTO();

        stationDTO.setID(station.getID());
        stationDTO.setStationName(station.getStationName());
        stationDTO.setLineId(station.getLineId());
        stationDTO.setPosition(station.getPosition());

        return stationDTO;
    }

    @Override
    public Station stationDtoToEntity(StationDTO stationDTO) {
        if (stationDTO == null) {
            return null;
        }

        Station station = new Station();

        station.setID(stationDTO.getID());
        station.setStationName(stationDTO.getStationName());
        station.setLineId(stationDTO.getLineId());
        station.setPosition(stationDTO.getPosition());

        return station;
    }
}
