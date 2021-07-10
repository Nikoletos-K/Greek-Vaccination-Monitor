package com.vaccsmonitor.vaccsmonitorsql.service;

import com.vaccsmonitor.vaccsmonitorsql.exceptions.RegionNotFoundException;
import com.vaccsmonitor.vaccsmonitorsql.model.Region;
import com.vaccsmonitor.vaccsmonitorsql.repositories.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegionService {
    private final RegionRepo regionRepo;

    @Autowired
    public RegionService(RegionRepo regionRepo) {
        this.regionRepo = regionRepo;
    }

    public Region addRegion(Region region) {
        //region.setId(UUID.randomUUID().toString());
        return regionRepo.save(region);
    }

    public List<Region> findAllRegions() {
        return regionRepo.findAll();
    }

    //public Region update

    public Region findRegionById(Long id) {
        return regionRepo.findRegionById(id)
                .orElseThrow( () -> new RegionNotFoundException("Region by id " + id + " was not found"));
    }


}
