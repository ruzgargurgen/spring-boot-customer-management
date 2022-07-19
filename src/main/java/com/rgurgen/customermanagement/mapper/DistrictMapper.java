package com.rgurgen.customermanagement.mapper;

import com.rgurgen.customermanagement.dtos.DistrictDto;
import com.rgurgen.customermanagement.model.District;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DistrictMapper {

    @Mapping(target = "town",source = "townDto")
    District districtDtoToDistrict(DistrictDto districtDto);

    @InheritInverseConfiguration
    DistrictDto districtToToDistrictDto(District district);

    List<District> DistrictsDtoToDistricts(List<DistrictDto> dtoList);

    List<DistrictDto> districtsToDistrictsDto(List<District> districts);

}
