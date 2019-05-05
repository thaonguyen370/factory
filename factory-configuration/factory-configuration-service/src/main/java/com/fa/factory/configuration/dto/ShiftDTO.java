package com.fa.factory.configuration.dto;

import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShiftDTO {
    private Long shiftId;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private String dayOfWeek;
    private Long lineId;
    private String factoryName;
    private String lineName;
    List<BreakTimeDTO> breakTimes = new ArrayList<>();
}
