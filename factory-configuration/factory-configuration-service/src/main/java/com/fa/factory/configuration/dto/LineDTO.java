package com.fa.factory.configuration.dto;

import lombok.Data;

@Data
public class LineDTO {
    private long id;
    private String lineName;
    private String lineManager;
    private long factoryId;
    private String factoryName;
    private int taktTime;
    private int targetOutput;
    private String targetFrequency;
}
