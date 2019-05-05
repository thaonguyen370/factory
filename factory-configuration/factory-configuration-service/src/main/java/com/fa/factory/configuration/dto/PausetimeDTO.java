package com.fa.factory.configuration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PausetimeDTO {
    private String name;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date startTime;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date endTime;
}