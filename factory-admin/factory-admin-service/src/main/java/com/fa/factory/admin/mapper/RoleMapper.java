package com.fa.factory.admin.mapper;

import com.fa.factory.admin.dto.RoleDto;
import com.fa.factory.admin.model.Role;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto roleToRoleDto(Role role);

    Role roleDtoToRole(RoleDto roleDto);

}


