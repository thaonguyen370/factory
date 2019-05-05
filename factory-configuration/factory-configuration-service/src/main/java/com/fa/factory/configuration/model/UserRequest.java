package com.fa.factory.configuration.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String firstName;
    private String lastName;
}
