package com.rgurgen.customermanagement.mapper;

import com.rgurgen.customermanagement.dtos.CountryDto;
import com.rgurgen.customermanagement.model.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDto countryToCountryDto(Country country);

    Country countryDtoToCountry(CountryDto dto);

    List<CountryDto> countriesToCountriesDto(List<Country> countries);

    List<Country> countriesDtoToCountries(List<CountryDto> dtoList);
}
