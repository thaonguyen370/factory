package com.fa.factory.admin.dto;


import com.fa.factory.common.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private Integer factoryId;

    private String firstName;

    private String lastName;

    private String sso;

    private String email;

    private String password;

    private List<Integer> listRoleId;
}
