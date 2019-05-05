package com.fa.factory.configuration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class LinePausetimeDTO {
    private long id;

    private String lineName;

    private String lineManager;

    private long factoryId;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date startTime;

    private int taktTime;

    private int targetOutput;

    private String targetFrequency;

    private PausetimeDTO pausetimeDTO;
}
