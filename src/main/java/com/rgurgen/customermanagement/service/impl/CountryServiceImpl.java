package com.rgurgen.customermanagement.service.impl;

import com.rgurgen.customermanagement.dtos.CountryDto;
import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.exceptions.NotFoundException;
import com.rgurgen.customermanagement.mapper.CountryMapper;
import com.rgurgen.customermanagement.model.Country;
import com.rgurgen.customermanagement.repos.CountryRepository;
import com.rgurgen.customermanagement.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    private final CountryMapper mapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper mapper) {
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public CountryDto save(CountryDto countryDto) {
        String code = countryRepository.findByCode(countryDto.getCode());
        if (code == null) {
            Country country = mapper.countryDtoToCountry(countryDto);
            return mapper.countryToCountryDto(countryRepository.save(country));
        }
        throw new IllegalArgumentException("Country code <--" + countryDto.getCode() + "--> already exist!");
    }

    @Override
    public PagedResultDto<CountryDto> getAllCountry(Pageable pageable) {
        Page<Country> pageCountry = countryRepository.findAll(pageable);
        PagedResultDto<CountryDto> response = new PagedResultDto<>();
        response.setStat(pageCountry, mapper.countriesToCountriesDto(pageCountry.getContent()));
        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    @Transactional
    public Integer updateCountryNameAndCode(Long id, String name,String code) {
       Country country= countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Country id not found!"));
       country.setName(name);
       country.setCode(code);
       countryRepository.updateCountryNameAndCode(country.getName(),country.getCode(),id);
        return 1;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public void delete(Long id) {
        countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Country id not found!"));
        countryRepository.deleteById(id);
    }
}
