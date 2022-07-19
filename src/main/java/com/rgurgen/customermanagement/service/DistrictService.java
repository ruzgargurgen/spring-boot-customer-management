package com.rgurgen.customermanagement.service;

import com.rgurgen.customermanagement.dtos.DistrictDto;
import com.rgurgen.customermanagement.dtos.PagedResultDto;
import org.springframework.data.domain.Pageable;

public interface DistrictService {
    DistrictDto save(DistrictDto districtDto);

    PagedResultDto<DistrictDto> getAll(Pageable pageable);

    void updateDistrictName(Long id, String name);

    void updateDistrictCode(Long id, String code);

    void updateDistrictTown(Long id, Long townId);
}
