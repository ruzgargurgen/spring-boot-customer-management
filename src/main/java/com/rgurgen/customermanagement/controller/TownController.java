package com.rgurgen.customermanagement.controller;

import com.rgurgen.customermanagement.dtos.PagedResultDto;
import com.rgurgen.customermanagement.dtos.TownDto;
import com.rgurgen.customermanagement.service.TownService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/town")
public class TownController {

    private final TownService townService;

    public TownController(TownService townService) {
        this.townService = townService;
    }

    @PostMapping
    public ResponseEntity<TownDto> createTown(@RequestBody TownDto townDto) {
        return ResponseEntity.ok(townService.save(townDto));
    }

    @GetMapping
    public ResponseEntity<PagedResultDto<TownDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(townService.getAll(pageable));
    }

    @PutMapping("edit/name/{id}")
    public ResponseEntity<Integer> updateTownName(@PathVariable("id") Long id, @RequestBody TownDto townDto) {
        townService.updateName(id, townDto.getName());
        return ResponseEntity.ok(1);
    }

    @PutMapping("edit/code/{id}")
    public ResponseEntity<Integer> updateTownCode(@PathVariable("id") Long id, @RequestBody TownDto townDto) {
        townService.updateCode(id, townDto.getCode());
        return ResponseEntity.ok(1);
    }

    @PutMapping("edit/city/{id}")
    public ResponseEntity<Integer> updateCity(@PathVariable("id") Long id, @RequestBody TownDto townDto) {
        townService.updateCity(id, townDto.getCityDto().getId());
        return ResponseEntity.ok(1);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        townService.delete(id);
    }
}
