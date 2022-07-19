package com.rgurgen.customermanagement.service.impl;

import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.dtos.TownDto;
import com.rgurgen.customermanagement.exceptions.ConstraintException;
import com.rgurgen.customermanagement.exceptions.NotFoundException;
import com.rgurgen.customermanagement.mapper.TownMapper;
import com.rgurgen.customermanagement.model.City;
import com.rgurgen.customermanagement.model.Town;
import com.rgurgen.customermanagement.repos.CityRepository;
import com.rgurgen.customermanagement.repos.TownRepository;
import com.rgurgen.customermanagement.service.TownService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    private final CityRepository cityRepository;

    private final TownMapper townMapper;

    public TownServiceImpl(TownRepository townRepository, CityRepository cityRepository, TownMapper townMapper) {
        this.townRepository = townRepository;
        this.cityRepository = cityRepository;
        this.townMapper = townMapper;
    }

    @Override
    public TownDto save(TownDto townDto) {
        City city = cityRepository.findById(townDto.getCityDto().getId()).orElseThrow(() -> new NotFoundException("City id not found!"));
        String code = townRepository.findByCode(townDto.getCode());
        if (code == null) {
            Town town = townMapper.townDtoToTown(townDto);
            town.setCity(city);
            townRepository.save(town);
            townDto = townMapper.townToTownDto(town);
            return townDto;
        }
        throw new ConstraintException("Town code already exist!");
    }

    @Override
    public PagedResultDto<TownDto> getAll(Pageable pageable) {
        Page data = townRepository.findAll(pageable);
        PagedResultDto<TownDto> pagedResultDto = new PagedResultDto<>();
        pagedResultDto.setStat(data, townMapper.townsToTownsDto(data.getContent()));
        return pagedResultDto;
    }

    @Override
    public void updateName(Long id, String name) {
        townRepository.findById(id).orElseThrow(() -> new NotFoundException("Town id not found!"));
        townRepository.updateName(id, name);
    }

    @Override
    public void updateCode(Long id, String code) {
        townRepository.findById(id).orElseThrow(() -> new NotFoundException("Town id not found!"));
        String result= townRepository.findByCode(code);
        if (result==null) {
            townRepository.updateCode(id, code);
        }
        throw new ConstraintException("Town code already exist!");
    }

    @Override
    public void updateCity(Long id, Long cityId) {
        townRepository.findById(id).orElseThrow(() -> new NotFoundException("Town id not found!"));
        cityRepository.findById(cityId).orElseThrow(() -> new NotFoundException("City id not found!"));
        townRepository.updateCity(id, cityId);
    }

    @Override
    public void delete(Long id) {
        townRepository.findById(id).orElseThrow(() -> new NotFoundException("Town id not found!"));
        townRepository.deleteById(id);
    }
}
