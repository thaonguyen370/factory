package com.fa.factory.configuration.service.impl;

import com.fa.factory.configuration.dto.ListDTO;
import com.fa.factory.configuration.mapper.ListMapper;
import com.fa.factory.configuration.repository.ListRepository;
import com.fa.factory.configuration.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListServiceImpl implements ListService {
    @Autowired
    private ListRepository listRepository;
    @Autowired
    private ListMapper listMapper;

    @Override
    public List<ListDTO> getAllList() {
        return listRepository.findAll().stream()
                .map(listMapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
