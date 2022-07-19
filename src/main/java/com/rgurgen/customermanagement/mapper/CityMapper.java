package com.rgurgen.customermanagement.mapper;

import com.rgurgen.customermanagement.dtos.CityDto;
import com.rgurgen.customermanagement.model.City;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "country",source = "countryDto")
    City cityDtoToCity(CityDto cityDto);

    @InheritInverseConfiguration
    CityDto cityToCityDto(City city);

    List<City> citiesDtoToCities(List<CityDto> citiesDto);

    List<CityDto> citiesToCitiesDto(List<City> cities);
}
