package com.rgurgen.customermanagement.mapper;

import com.rgurgen.customermanagement.dtos.StreetDto;
import com.rgurgen.customermanagement.model.Street;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StreetMapper {

    @Mapping(target = "district",source = "districtDto")
    Street streetDtoToStreet(StreetDto streetDto);

    @InheritInverseConfiguration
    StreetDto streetToStreetDto(Street street);

    List<Street> streetsDtoToStreets(List<StreetDto> dtoList);

    List<StreetDto> streetsToStreetsDto(List<Street> streets);
}
