package com.fa.factory.configuration.service.impl;


import com.fa.factory.configuration.dto.StationDTO;
import com.fa.factory.configuration.mapper.StationMapper;
import com.fa.factory.configuration.model.Factory;
import com.fa.factory.configuration.model.Line;
import com.fa.factory.configuration.model.Station;
import com.fa.factory.configuration.repository.FactoryRepository;
import com.fa.factory.configuration.repository.LineRepository;
import com.fa.factory.configuration.repository.StationRepository;
import com.fa.factory.configuration.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private StationMapper stationMapper;

    @Autowired
    private LineRepository lineRepository;

    @Autowired
    private FactoryRepository factoryRepository;

    @Override
    public void createStation(StationDTO stationDTO) {

        Station station = stationMapper.stationDtoToEntity(stationDTO);
        stationRepository.save(station);
    }

    @Override
    public List<StationDTO> getAllStations() {

        return stationRepository
                .findAll()
                .stream()
                .map(station -> convert(station))
                .collect(Collectors.toList());
    }

    private StationDTO convert(Station station) {

        StationDTO dto = stationMapper.entityToStationDto(station);
        Line line = lineRepository.findById(station.getLineId()).orElse(null);
        Factory factory = factoryRepository.findById(line.getFactoryId()).orElse(null);

        if (factory != null) {
            dto.setFactoryId(factory.getId());
            dto.setFactoryName(factory.getFactoryName());
        }

        if (line != null)
            dto.setLineName(line.getLineName());
        return dto;
    }

    @Override
    public boolean validatePosition(StationDTO stationDTO) {

        Station station = stationRepository.findByPositionAndLineId(stationDTO.getPosition(), stationDTO.getLineId());
        return station != null;
    }

}
