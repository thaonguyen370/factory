package com.fa.factory.configuration.service.impl;

import com.fa.factory.common.exceptions.FactoryException;
import com.fa.factory.configuration.dto.LineDTO;
import com.fa.factory.configuration.dto.LineNameDTO;
import com.fa.factory.configuration.dto.LinePausetimeDTO;
import com.fa.factory.configuration.dto.PausetimeDTO;
import com.fa.factory.configuration.mapper.LineNameMapper;
import com.fa.factory.configuration.model.Factory;
import com.fa.factory.configuration.model.PauseTime;
import com.fa.factory.configuration.repository.FactoryRepository;
import com.fa.factory.configuration.repository.LineRepository;
import com.fa.factory.configuration.mapper.LineMapper;
import com.fa.factory.configuration.model.Line;
import com.fa.factory.configuration.repository.PausetimeRepository;
import com.fa.factory.configuration.service.LineService;
import org.apache.commons.lang.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineServiceImpl implements LineService {
    @Autowired
    private LineRepository lineRepository;
    @Autowired
    private PausetimeRepository pausetimeRepository;
    @Autowired
    private LineMapper lineMapper = Mappers.getMapper(LineMapper.class);
    @Autowired
    private FactoryRepository factoryRepository;
    private LineNameMapper lineNameMapper = Mappers.getMapper(LineNameMapper.class);

    @Override
    public List<LineDTO> getAll() {
        return lineRepository.findAll().stream().map(line -> convertLineToLineDTO(line))
                .collect(Collectors.toList());
    }

    @Override
    public LineDTO convertLineToLineDTO(Line line) {
        LineDTO lineDTO = lineMapper.lineToLineDto(line);
        Factory factory = factoryRepository.findById(line.getFactoryId()).orElse(null);
        String factoryName = StringUtils.EMPTY;
        if (factory != null) factoryName = factory.getFactoryName();
        lineDTO.setFactoryName(factoryName);
        return lineDTO;
    }

    @Override
    public LineNameDTO convertEntityToDTO(Line line) {
        LineNameDTO dto = lineNameMapper.entityToDTO(line);
        return dto;
    }

    @Override
    public List getAllLineName(long id) throws FactoryException {

        return lineRepository.findAllByFactoryId(id).stream()
                .map(line -> convertEntityToDTO(line))
                .collect(Collectors.toList());
    }

    @Override
    public void save(LinePausetimeDTO linePausetimeDTO) {
        Line line = lineMapper.linePausetimeDtoToLine(linePausetimeDTO);
        PauseTime pauseTime = lineMapper.linePauseTimeDtoToPausetime(linePausetimeDTO.getPausetimeDTO());
        long lineid = lineRepository.save(line).getId();
        pauseTime.setLineId(lineid);
        pausetimeRepository.save(pauseTime);
    }

    @Override
    public boolean CheckDate(PausetimeDTO pausetimeDTO) {
        if (pausetimeDTO.getStartTime().before(pausetimeDTO.getEndTime()))
            return true;
        return false;
    }


}
