package com.vaccsmonitor.vaccsmonitorsql.service;


import java.io.IOException;
import java.util.List;

import com.vaccsmonitor.vaccsmonitorsql.io.CSVParser;
import com.vaccsmonitor.vaccsmonitorsql.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class CSVService {

    private RegionService repository;

    public void save() {
        List<Region> regions = CSVParser.csvToRegions();
        for(Region r: regions){
            repository.addRegion(r);
        }
    }

}