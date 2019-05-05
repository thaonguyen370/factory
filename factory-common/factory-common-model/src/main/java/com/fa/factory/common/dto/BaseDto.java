package com.fa.factory.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean active;
    private Date created;
    private String createdBy;
    private Date updated;
    private String updatedBy;

}
