package com.fa.factory.configuration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "line_id")
    private long lineId;

    @Column(name = "position")
    private Integer position;
}
