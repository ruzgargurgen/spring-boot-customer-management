package com.rgurgen.customermanagement.controller;

import com.rgurgen.customermanagement.dtos.CountryDto;
import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@Valid @RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.save(countryDto));
    }

    @GetMapping
    public ResponseEntity<PagedResultDto<CountryDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(countryService.getAllCountry(pageable));
    }

    @PutMapping("{id}")
    public ResponseEntity<Integer> updateCountryNameAndCode(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.updateCountryNameAndCode(id, countryDto.getName(), countryDto.getCode()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        countryService.delete(id);
    }

}
