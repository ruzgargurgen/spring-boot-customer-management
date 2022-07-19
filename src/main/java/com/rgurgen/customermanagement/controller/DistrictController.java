package com.rgurgen.customermanagement.controller;

import com.rgurgen.customermanagement.dtos.DistrictDto;
import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.service.DistrictService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/district")
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping
    public ResponseEntity<DistrictDto> createDistrict(@RequestBody DistrictDto districtDto) {
        return ResponseEntity.ok(districtService.save(districtDto));
    }

    @GetMapping
    public ResponseEntity<PagedResultDto<DistrictDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(districtService.getAll(pageable));
    }

    @PutMapping("edit/name/{id}")
    public ResponseEntity<Integer> updateDistrictName(@PathVariable("id") Long id, @RequestBody DistrictDto districtDto) {
        districtService.updateDistrictName(id, districtDto.getName());
        return ResponseEntity.ok(1);
    }

    @PutMapping("edit/code/{id}")
    public ResponseEntity<Integer> updateDistrictCode(@PathVariable("id") Long id, @RequestBody DistrictDto districtDto) {
        districtService.updateDistrictCode(id, districtDto.getCode());
        return ResponseEntity.ok(1);
    }

    @PutMapping("edit/town/{id}")
    public ResponseEntity<Integer> updateTown(@PathVariable("id") Long id, @RequestBody DistrictDto districtDto) {
        districtService.updateDistrictTown(id, districtDto.getTownDto().getId());
        return ResponseEntity.ok(1);
    }
}
