package com.rgurgen.customermanagement.service.impl;

import com.rgurgen.customermanagement.dtos.CityDto;
import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.exceptions.ConstraintException;
import com.rgurgen.customermanagement.exceptions.NotFoundException;
import com.rgurgen.customermanagement.mapper.CityMapper;
import com.rgurgen.customermanagement.model.City;
import com.rgurgen.customermanagement.model.Country;
import com.rgurgen.customermanagement.repos.CityRepository;
import com.rgurgen.customermanagement.repos.CountryRepository;
import com.rgurgen.customermanagement.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final CountryRepository countryRepository;

    private final CityMapper cityMapper;

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public CityDto save(CityDto cityDto) {
        Country country = countryRepository.findById(cityDto.getCountryDto().getId())
                .orElseThrow(() -> new NotFoundException("Country id not found!"));
        String code = cityRepository.findByCode(cityDto.getCode());
        if (code == null) {
            City city = cityMapper.cityDtoToCity(cityDto);
            city.setCountry(country);
            return cityMapper.cityToCityDto(cityRepository.save(city));
        }
        throw new ConstraintException("City code already exist!");
    }

    @Override
    public PagedResultDto<CityDto> getAll(Pageable pageable) {
        Page data = cityRepository.findAll(pageable);
        PagedResultDto<CityDto> pagedResultDto = new PagedResultDto<>();
        pagedResultDto.setStat(data, cityMapper.citiesToCitiesDto(data.getContent()));
        return pagedResultDto;
    }

    @Override
    public void updateName(Long id, String name) {
        cityRepository.findById(id).orElseThrow(() -> new NotFoundException("City id not found!"));
        cityRepository.updateName(id, name);
    }

    @Override
    public void updateCode(Long id, String code) {
        cityRepository.findById(id).orElseThrow(() -> new NotFoundException("City id not found!"));
        String result = cityRepository.findByCode(code);
        if (result == null) {
            cityRepository.updateCode(id, code);
        }
        throw new ConstraintException("City code already exist!");
    }

    @Override
    public void updateCountry(Long id, Long countryId) {
        cityRepository.findById(id).orElseThrow(() -> new NotFoundException("City id not found!"));
        countryRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Country id not found!"));
        cityRepository.updateCountry(id, countryId);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.findById(id).orElseThrow(() -> new NotFoundException("City id not found!"));
        cityRepository.deleteById(id);
    }
}
