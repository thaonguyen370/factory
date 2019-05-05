package com.fa.factory.admin.mapper;

import com.fa.factory.admin.dto.RoleDto;
import com.fa.factory.admin.model.Role;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto roleToRoleDto(Role role) {
        if (role == null) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setRoleId(role.getRoleId());
        roleDto.setRoleName(role.getRoleName());
        roleDto.setCreatedBy(role.getCreatedBy());

        return roleDto;
    }

    @Override
    public Role roleDtoToRole(RoleDto roleDto) {
        if (roleDto == null) {
            return null;
        }

        Role role = new Role();

        role.setRoleId(roleDto.getRoleId());
        role.setRoleName(roleDto.getRoleName());
        role.setCreatedBy(roleDto.getCreatedBy());

        return role;
    }
}
