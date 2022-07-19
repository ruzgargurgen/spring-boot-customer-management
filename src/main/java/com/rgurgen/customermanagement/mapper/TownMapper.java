package com.rgurgen.customermanagement.mapper;

import com.rgurgen.customermanagement.dtos.TownDto;
import com.rgurgen.customermanagement.model.Town;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TownMapper {

    @Mapping(target = "city",source = "cityDto")
    Town townDtoToTown(TownDto townDto);

    @InheritInverseConfiguration
    TownDto townToTownDto(Town town);

    List<Town> townsDtoToTowns(List<TownDto> townsDto);
    List<TownDto> townsToTownsDto(List<Town> towns);
}
