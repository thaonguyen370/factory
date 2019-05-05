package com.fa.factory.configuration.dto;

import lombok.*;

import java.time.LocalTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BreakTimeDTO {

    private Long breakTimeId;

    private String name;

    private LocalTime startTime;

    private LocalTime endTime;

    private Long shiftId;
}
