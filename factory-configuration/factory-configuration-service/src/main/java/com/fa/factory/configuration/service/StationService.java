package com.fa.factory.configuration.service;

import com.fa.factory.configuration.dto.StationDTO;

import java.util.List;

public interface StationService {
    void createStation(StationDTO stationDTO);

    List<StationDTO> getAllStations();

    boolean validatePosition(StationDTO stationDTO);

}
