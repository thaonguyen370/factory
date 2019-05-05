package com.fa.factory.admin.service.impl;

import com.fa.factory.admin.dto.RoleDto;
import com.fa.factory.admin.mapper.RoleMapper;
import com.fa.factory.admin.model.Role;
import com.fa.factory.admin.repository.RoleRepository;
import com.fa.factory.admin.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleDto> findAllRole() {
        List<Role> listRole = roleRepository.findAll();
        List<RoleDto> listRoleDto = new ArrayList<>();
        for (Role role : listRole)
            listRoleDto.add(roleMapper.roleToRoleDto(role));
        return listRoleDto;
    }

    @Override
    public RoleDto findById(int id) {
        return roleMapper.roleToRoleDto(roleRepository.findById(id));
    }
}
