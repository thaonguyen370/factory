package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.ListDTO;
import com.fa.factory.configuration.model.ListFactory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListMapper {
    ListDTO entityToDTO(ListFactory listFactory);

    ListFactory DTOToEntity(ListDTO listDTO);
}
