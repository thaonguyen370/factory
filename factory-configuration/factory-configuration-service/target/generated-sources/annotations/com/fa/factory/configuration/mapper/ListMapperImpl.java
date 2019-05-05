package com.fa.factory.configuration.mapper;

import com.fa.factory.configuration.dto.ListDTO;
import com.fa.factory.configuration.model.ListFactory;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class ListMapperImpl implements ListMapper {

    @Override
    public ListDTO entityToDTO(ListFactory listFactory) {
        if (listFactory == null) {
            return null;
        }

        ListDTO listDTO = new ListDTO();

        listDTO.setId(listFactory.getId());
        listDTO.setFactoryName(listFactory.getFactoryName());
        listDTO.setCountry(listFactory.getCountry());
        listDTO.setCity(listFactory.getCity());
        listDTO.setTaskContact(listFactory.getTaskContact());
        listDTO.setTimeZone(listFactory.getTimeZone());

        return listDTO;
    }

    @Override
    public ListFactory DTOToEntity(ListDTO listDTO) {
        if (listDTO == null) {
            return null;
        }

        ListFactory listFactory = new ListFactory();

        listFactory.setId(listDTO.getId());
        listFactory.setFactoryName(listDTO.getFactoryName());
        listFactory.setCountry(listDTO.getCountry());
        listFactory.setCity(listDTO.getCity());
        listFactory.setTaskContact(listDTO.getTaskContact());
        listFactory.setTimeZone(listDTO.getTimeZone());

        return listFactory;
    }
}
