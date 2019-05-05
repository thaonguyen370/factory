package com.fa.factory.configuration.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListDTO {
    int id;
    String factoryName;
    String country;
    String city;
    String taskContact;
    String eandon;
    String timeZone;
}

