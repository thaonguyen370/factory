package com.fa.factory.configuration.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shift")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shift_id")
    private Long shiftId;

    @Column(name = "name")
    private String name;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @Column(name = "line_id")
    private Long lineId;
}


