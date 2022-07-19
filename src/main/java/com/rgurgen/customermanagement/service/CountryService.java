package com.rgurgen.customermanagement.service;

import com.rgurgen.customermanagement.dtos.CountryDto;
import com.rgurgen.customermanagement.dtos.PagedResultDto;
import org.springframework.data.domain.Pageable;

public interface CountryService {

    CountryDto save(CountryDto countryDto);

    PagedResultDto<CountryDto> getAllCountry(Pageable pageable);

    Integer updateCountryNameAndCode(Long id, String name,String code);

    void delete(Long id);
}
