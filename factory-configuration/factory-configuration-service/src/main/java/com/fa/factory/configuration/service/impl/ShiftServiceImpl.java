package com.fa.factory.configuration.service.impl;

import com.fa.factory.configuration.dto.BreakTimeDTO;
import com.fa.factory.configuration.dto.ShiftDTO;
import com.fa.factory.configuration.mapper.BreakTimeMapper;
import com.fa.factory.configuration.mapper.ShiftMapper;
import com.fa.factory.configuration.model.BreakTime;
import com.fa.factory.configuration.model.Factory;
import com.fa.factory.configuration.model.Line;
import com.fa.factory.configuration.model.Shift;
import com.fa.factory.configuration.repository.BreakTimeRepository;
import com.fa.factory.configuration.repository.FactoryRepository;
import com.fa.factory.configuration.repository.LineRepository;
import com.fa.factory.configuration.repository.ShiftRepository;
import com.fa.factory.configuration.service.ShiftService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ShiftServiceImpl implements ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;
    @Autowired
    private BreakTimeRepository breakTimeRepository;
    @Autowired
    private ShiftMapper shiftMapper;
    @Autowired
    private BreakTimeMapper breakTimeMapper;
    @Autowired
    private FactoryRepository factoryRepository;
    @Autowired
    private LineRepository lineRepository;

    @Override
    public ShiftDTO createShift(ShiftDTO shiftDTO) {

        Shift shift = shiftMapper.ShiftDTOToShift(shiftDTO);

        if (shift == null) return null;

        Shift shift_return = shiftRepository.save(shift);

        return shiftMapper.ShiftToShiftDTO(shift_return);
    }

    public boolean validateTimeIsMid(LocalTime start, LocalTime end, LocalTime mid_start, LocalTime mid_end) {
        return mid_start.isBefore(mid_end)
                && mid_start.isAfter(start) && mid_start.isBefore(end)
                && mid_end.isAfter(start) && mid_end.isBefore(end);
    }

    public boolean validateTimeShiftInLine(ShiftDTO shiftDTO) {

        List<Shift> shifts = shiftRepository.findAllByLineId(shiftDTO.getLineId());

        if (shifts.isEmpty()) return true;

        LocalTime time_start = shiftDTO.getStartTime();
        LocalTime time_end = shiftDTO.getEndTime();
        boolean is_overlap;

        for (Shift shift : shifts) {
            is_overlap = validateTimeOverlapped(shift.getStartTime(), shift.getEndTime(), time_start, time_end);
            if (is_overlap) return false;
        }
        return true;
    }

    private boolean validateTimeOverlapped(LocalTime start, LocalTime end, LocalTime overlap_start, LocalTime overlap_end) {

        if (overlap_end.compareTo(overlap_start) <= 0) return true;

        return !((overlap_start.compareTo(start) < 0 && overlap_end.compareTo(start) <= 0)
                || (overlap_start.compareTo(end) >= 0 && overlap_end.compareTo(end) > 0));
    }

    @Override
    public List<BreakTimeDTO> createListBreakTimes(List<BreakTime> listBreakTime) {
        if (!listBreakTime.isEmpty()) {
            List<BreakTime> breakTimes = breakTimeRepository.saveAll(listBreakTime);
            return breakTimes.stream()
                    .map(breakTimeMapper::breakTimeToBreakTimeDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List getAllShift() {
        return shiftRepository.findAll().stream().map(line -> convertShiftToShiftDTO(line))
                .collect(Collectors.toList());
    }

    @Override
    public ShiftDTO convertShiftToShiftDTO(Shift shift) {
        ShiftDTO shiftDTO = shiftMapper.ShiftToShiftDTO(shift);
        Line line = lineRepository.findById(shift.getLineId()).orElse(null);
        String lineName = StringUtils.EMPTY;
        if (line != null) {
            lineName = line.getLineName();
        }
        Factory factory = factoryRepository.findById(line.getFactoryId()).orElse(null);
        String factoryName = StringUtils.EMPTY;
        if (factory != null) {
            factoryName = factory.getFactoryName();
        }
        shiftDTO.setLineName(lineName);
        shiftDTO.setFactoryName(factoryName);
        return shiftDTO;
    }

}

