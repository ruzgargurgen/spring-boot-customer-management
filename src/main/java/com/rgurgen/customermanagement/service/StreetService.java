package com.rgurgen.customermanagement.service;

import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.dtos.StreetDto;
import org.springframework.data.domain.Pageable;

public interface StreetService {
    StreetDto save(StreetDto streetDto);

    PagedResultDto<StreetDto> getAll(Pageable pageable);

    void updateStreetName(Long id, String name);

    void updateStreetCode(Long id, String code);

    void updateDistrict(Long id, Long districtId);
}
