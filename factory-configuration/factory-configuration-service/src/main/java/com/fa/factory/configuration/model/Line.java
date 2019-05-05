package com.fa.factory.configuration.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "line")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "line_name")
    private String lineName;

    @Column(name = "line_manager")
    private String lineManager;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "takt_time")
    private int taktTime;

    @Column(name = "target_output")
    private int targetOutput;

    @Column(name = "target_frequency")
    private String targetFrequency;

    @Column(name = "factory_id")
    private long factoryId;
}
