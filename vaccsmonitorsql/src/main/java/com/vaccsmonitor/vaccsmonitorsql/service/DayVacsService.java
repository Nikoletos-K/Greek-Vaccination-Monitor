package com.vaccsmonitor.vaccsmonitorsql.service;

import com.vaccsmonitor.vaccsmonitorsql.exceptions.RegionNotFoundException;
import com.vaccsmonitor.vaccsmonitorsql.model.DayVacs;
import com.vaccsmonitor.vaccsmonitorsql.model.Region;
import com.vaccsmonitor.vaccsmonitorsql.repositories.DayVacsRepository;
import com.vaccsmonitor.vaccsmonitorsql.repositories.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DayVacsService {
    private final DayVacsRepository regionRepo;

    @Autowired
    public DayVacsService(DayVacsRepository regionRepo) {
        this.regionRepo = regionRepo;
    }

    public DayVacs addDayVacs(DayVacs dayVacs) {
        return regionRepo.save(dayVacs);
    }

    //public List<DayVacs> getDayVacsByRegion(Long id){
        //return regionRepo.getDayVacsByRegion(id);
    //}

}
