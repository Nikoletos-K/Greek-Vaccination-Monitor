package com.vaccsmonitor.vaccsmonitorsql;

import com.vaccsmonitor.vaccsmonitorsql.model.Region;
import com.vaccsmonitor.vaccsmonitorsql.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/region")
public class RegionResource {
    private final RegionService regionService;

    public RegionResource(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Region>>  getAllRegions() {
        List<Region> regions = regionService.findAllRegions();
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Region>  getRegionById(@PathVariable("id") Long id) {
        Region region = regionService.findRegionById(id);
        return new ResponseEntity<>(region, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Region> addRegion(@RequestBody Region region) {
        Region newRegion = regionService.addRegion(region);
        return new ResponseEntity<>(newRegion, HttpStatus.CREATED);
    }
}
