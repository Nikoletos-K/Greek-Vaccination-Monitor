package com.vaccsmonitor.vaccsmonitorsql;

//import com.vaccsmonitor.vaccsmonitorsql.model.DayVacs;
import com.vaccsmonitor.vaccsmonitorsql.model.DayVacs;
import com.vaccsmonitor.vaccsmonitorsql.model.Region;
import com.vaccsmonitor.vaccsmonitorsql.service.DayVacsService;
import com.vaccsmonitor.vaccsmonitorsql.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/region")
public class RegionResource {

    private final RegionService regionService;

    @Autowired
    DayVacsService dayVacsService;

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


    @GetMapping("/find/population/{id}")
    public ResponseEntity<Integer>  getRegionPopulationById(@PathVariable("id") Long id) {
        Region region = regionService.findRegionById(id);
        Integer population = region.getPopulation();
        System.out.println(population);
        return new ResponseEntity<>(population, HttpStatus.OK);
    }

    @GetMapping("/find/dates/{id}")
    public ResponseEntity<List<DayVacs>>  getDayVacsByRegion(@PathVariable("id") Long id) {
        Region region = regionService.findRegionById(id);
        List<DayVacs> dayVacs = region.getDayVacs();
        return new ResponseEntity<>(dayVacs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Region> addRegion(@RequestBody Region region) {
        Region newRegion = regionService.addRegion(region);
        return new ResponseEntity<>(newRegion, HttpStatus.CREATED);
    }
}
