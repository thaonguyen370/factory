package com.fa.factory.configuration.service;

import com.fa.factory.common.exceptions.FactoryException;
import com.fa.factory.configuration.dto.LineDTO;
import com.fa.factory.configuration.dto.LineNameDTO;
import com.fa.factory.configuration.dto.LinePausetimeDTO;
import com.fa.factory.configuration.dto.PausetimeDTO;
import com.fa.factory.configuration.model.Line;

import java.util.List;

public interface LineService {
    List<LineDTO> getAll();

    LineDTO convertLineToLineDTO(Line line);

    LineNameDTO convertEntityToDTO(Line line);

    List getAllLineName(long id) throws FactoryException;

    public void save(LinePausetimeDTO linePausetimeDTO);

    public boolean CheckDate(PausetimeDTO pausetimeDTO);
}
