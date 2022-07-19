package com.rgurgen.customermanagement.controller;

import com.rgurgen.customermanagement.dtos.CityDto;
import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.service.CityService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<CityDto> createCity(@RequestBody CityDto cityDto) {
        return ResponseEntity.ok(cityService.save(cityDto));
    }

    @GetMapping
    public ResponseEntity<PagedResultDto<CityDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(cityService.getAll(pageable));
    }

    @PutMapping("edit/name/{id}")
    public ResponseEntity<Integer> updateCityName(@PathVariable("id") Long id, @RequestBody CityDto cityDto) {
        cityService.updateName(id, cityDto.getName());
        return ResponseEntity.ok(1);
    }

    @PutMapping("edit/code/{id}")
    public ResponseEntity<Integer> updateCityCode(@PathVariable("id") Long id, @RequestBody CityDto cityDto) {
        cityService.updateCode(id, cityDto.getCode());
        return ResponseEntity.ok(1);
    }

    @PutMapping("edit/country/{id}")
    public ResponseEntity<Integer> updateCity(@PathVariable("id") Long id, @RequestBody CityDto cityDto) {
        cityService.updateCountry(id, cityDto.getCountryDto().getId());
        return ResponseEntity.ok(1);
    }

    @DeleteMapping("{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
