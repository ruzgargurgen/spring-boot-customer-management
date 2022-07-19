package com.rgurgen.customermanagement.controller;

import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.dtos.StreetDto;
import com.rgurgen.customermanagement.service.StreetService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/street")
public class StreetController {

    public final StreetService streetService;

    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @PostMapping
    public ResponseEntity<StreetDto> createStreet(@RequestBody StreetDto streetDto) {
        return ResponseEntity.ok(streetService.save(streetDto));
    }

    @GetMapping
    public ResponseEntity<PagedResultDto<StreetDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(streetService.getAll(pageable));
    }

    @PutMapping("edit/name/{id}")
    public ResponseEntity<Integer> updateStreetName(@PathVariable("id") Long id, @RequestBody StreetDto streetDto) {
        streetService.updateStreetName(id, streetDto.getName());
        return ResponseEntity.ok(1);
    }

    @PutMapping("edit/code/{id}")
    public ResponseEntity<Integer> updateStreetCode(@PathVariable("id") Long id, @RequestBody StreetDto streetDto) {
        streetService.updateStreetCode(id, streetDto.getCode());
        return ResponseEntity.ok(1);
    }

    @PutMapping("edit/district/{id}")
    public ResponseEntity<Integer> updateDistrict(@PathVariable("id") Long id, @RequestBody StreetDto streetDto) {
        streetService.updateDistrict(id, streetDto.getDistrictDto().getId());
        return ResponseEntity.ok(1);
    }
}
