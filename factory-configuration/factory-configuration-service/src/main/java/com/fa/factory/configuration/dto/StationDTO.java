package com.fa.factory.configuration.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class StationDTO {

    private Long ID;
    private String stationName;
    private String factoryName;
    private long factoryId;
    private String lineName;
    private long lineId;
    private Integer position;

}
