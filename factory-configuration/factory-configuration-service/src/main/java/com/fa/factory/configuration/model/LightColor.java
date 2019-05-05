package com.fa.factory.configuration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LightColor {

    @JsonProperty("Color")
    private String color;

    @JsonProperty("Mode")
    private String mode;

    @JsonProperty("ProductId")
    private String productId;

}
