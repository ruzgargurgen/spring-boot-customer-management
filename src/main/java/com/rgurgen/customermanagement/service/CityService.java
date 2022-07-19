package com.rgurgen.customermanagement.service;

import com.rgurgen.customermanagement.dtos.CityDto;
import com.rgurgen.customermanagement.dtos.PagedResultDto;
import org.springframework.data.domain.Pageable;

public interface CityService {
    CityDto save(CityDto cityDto);

    PagedResultDto<CityDto> getAll(Pageable pageable);

    void updateName(Long id, String name);

    void updateCountry(Long id, Long countryId);

    void updateCode(Long id, String code);

    void deleteCity(Long id);
}
