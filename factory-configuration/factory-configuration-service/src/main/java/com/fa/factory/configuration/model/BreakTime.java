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
@Table(name = "break_time")
public class BreakTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "break_time_id", unique = true, nullable = false)
    private Long breakTimeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "shift_id", nullable = false)
    private Long shiftId;
}
