package com.rgurgen.customermanagement.service.impl;

import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.dtos.StreetDto;
import com.rgurgen.customermanagement.exceptions.ConstraintException;
import com.rgurgen.customermanagement.exceptions.NotFoundException;
import com.rgurgen.customermanagement.mapper.StreetMapper;
import com.rgurgen.customermanagement.model.District;
import com.rgurgen.customermanagement.model.Street;
import com.rgurgen.customermanagement.repos.DistrictRepository;
import com.rgurgen.customermanagement.repos.StreetRepository;
import com.rgurgen.customermanagement.service.StreetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;
    private final DistrictRepository districtRepository;
    private final StreetMapper streetMapper;

    public StreetServiceImpl(StreetRepository streetRepository, DistrictRepository districtRepository, StreetMapper streetMapper) {
        this.streetRepository = streetRepository;
        this.districtRepository = districtRepository;
        this.streetMapper = streetMapper;
    }

    @Override
    public StreetDto save(StreetDto streetDto) {
        District district = districtRepository.findById(streetDto.getDistrictDto().getId())
                .orElseThrow(() -> new NotFoundException("District id not found!"));
        String code = streetRepository.findByCode(streetDto.getCode());
        if (code == null) {
            Street street = streetMapper.streetDtoToStreet(streetDto);
            street.setDistrict(district);
            streetRepository.save(street);
            return streetMapper.streetToStreetDto(street);
        }
        throw new ConstraintException("Street code already exist!");
    }

    @Override
    public PagedResultDto<StreetDto> getAll(Pageable pageable) {
        Page data=streetRepository.findAll(pageable);
        PagedResultDto<StreetDto> pagedResultDto=new PagedResultDto<>();
        pagedResultDto.setStat(data,streetMapper.streetsToStreetsDto(data.getContent()));
        return pagedResultDto;
    }

    @Override
    public void updateStreetName(Long id, String name) {
        streetRepository.findById(id).orElseThrow(()->new NotFoundException("Street id not found!"));
        streetRepository.updateStreetName(id,name);
    }

    @Override
    public void updateStreetCode(Long id, String code) {
        streetRepository.findById(id).orElseThrow(()->new NotFoundException("Street id not found!"));
        String result= streetRepository.findByCode(code);
        if (result==null) {
            streetRepository.updateStreetCode(id, code);
        }
        throw new ConstraintException("Street code already exist!");
    }

    @Override
    public void updateDistrict(Long id, Long districtId) {
        Street street=streetRepository.findById(id).orElseThrow(()->new NotFoundException("Street id not found!"));
        District district=districtRepository.findById(districtId).orElseThrow(()->new NotFoundException("District id not found!"));
        street.setDistrict(district);
        districtRepository.updateTown(id,districtId);
    }
}
