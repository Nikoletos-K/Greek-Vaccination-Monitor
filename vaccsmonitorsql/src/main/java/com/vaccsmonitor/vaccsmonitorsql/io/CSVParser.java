package com.vaccsmonitor.vaccsmonitorsql.io;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.vaccsmonitor.vaccsmonitorsql.model.DayVacs;
import com.vaccsmonitor.vaccsmonitorsql.model.Region;


import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.vaccsmonitor.vaccsmonitorsql.repositories.RegionRepo;
import com.vaccsmonitor.vaccsmonitorsql.service.RegionService;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CSVParser {

    public RegionRepo regionRepository;

    public static List<Region> csvToRegions() {

        List<Region> regionArray = new ArrayList<Region>();

        String fileName = "C:\\Users\\nikol\\Desktop\\vaccsmonitorsql\\data\\populationRegionalUnits.csv";

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
            r.remove(0);

            for (String[] x: r) {

                for(String xx: x) {
                    System.out.println(xx);
                }

                Region newRegion = new Region(Long.parseLong(x[0]),x[1],Integer.parseInt(x[2].replace(".","")));
                regionArray.add(newRegion);
            }
            return regionArray;
        } catch (IOException | CsvException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}