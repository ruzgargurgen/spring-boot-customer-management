package com.rgurgen.customermanagement.service.impl;

import com.rgurgen.customermanagement.dtos.DistrictDto;
import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.exceptions.ConstraintException;
import com.rgurgen.customermanagement.exceptions.NotFoundException;
import com.rgurgen.customermanagement.mapper.DistrictMapper;
import com.rgurgen.customermanagement.model.District;
import com.rgurgen.customermanagement.model.Town;
import com.rgurgen.customermanagement.repos.DistrictRepository;
import com.rgurgen.customermanagement.repos.TownRepository;
import com.rgurgen.customermanagement.service.DistrictService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    private final TownRepository townRepository;

    private final DistrictMapper districtMapper;

    public DistrictServiceImpl(DistrictRepository districtRepository, TownRepository townRepository, DistrictMapper districtMapper) {
        this.districtRepository = districtRepository;
        this.townRepository = townRepository;
        this.districtMapper = districtMapper;
    }

    @Override
    public DistrictDto save(DistrictDto districtDto) {
        Town town = townRepository.findById(districtDto.getTownDto().getId())
                .orElseThrow(() -> new NotFoundException("Town id not found!"));
        String code = districtRepository.findByCode(districtDto.getCode());
        if (code == null) {
            District district = districtMapper.districtDtoToDistrict(districtDto);
            district.setTown(town);
            districtRepository.save(district);
            return districtMapper.districtToToDistrictDto(district);
        }
        throw new ConstraintException("District code already exist!");
    }

    @Override
    public PagedResultDto<DistrictDto> getAll(Pageable pageable) {
        Page data=districtRepository.findAll(pageable);
        PagedResultDto<DistrictDto> pagedResultDto=new PagedResultDto<>();
        pagedResultDto.setStat(data,districtMapper.districtsToDistrictsDto(data.getContent()));
        return pagedResultDto;
    }

    @Override
    public void updateDistrictName(Long id, String name) {
        districtRepository.findById(id).orElseThrow(()->new NotFoundException("District id not found!"));
        districtRepository.updateDistrictName(id,name);
    }

    @Override
    public void updateDistrictCode(Long id, String code) {
        districtRepository.findById(id).orElseThrow(()->new NotFoundException("District id not found!"));
        String result= districtRepository.findByCode(code);
        if (result==null) {
            districtRepository.updateDistrictCode(id,code);
        }
        throw new ConstraintException("District code already exist!");

    }

    @Override
    public void updateDistrictTown(Long id, Long townId) {
        District district=districtRepository.findById(id).orElseThrow(()->new NotFoundException("District id not found!"));
        Town town=townRepository.findById(townId).orElseThrow(()->new NotFoundException("Town id not found!"));
        district.setTown(town);
        districtRepository.updateTown(id,townId);
    }
}
