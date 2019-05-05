package com.fa.factory.admin.service;

import com.fa.factory.admin.dto.RoleDto;
import com.fa.factory.admin.model.Role;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAllRole();

    RoleDto findById(int id);
}
