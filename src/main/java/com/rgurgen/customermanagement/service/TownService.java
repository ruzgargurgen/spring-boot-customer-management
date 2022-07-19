package com.rgurgen.customermanagement.service;

import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.dtos.TownDto;
import org.springframework.data.domain.Pageable;

public interface TownService {

    TownDto save(TownDto townDto);

    PagedResultDto<TownDto> getAll(Pageable pageable);

    void updateName(Long id, String name);

    void delete(Long id);

    void updateCity(Long id, Long cityId);

    void updateCode(Long id, String code);
}
