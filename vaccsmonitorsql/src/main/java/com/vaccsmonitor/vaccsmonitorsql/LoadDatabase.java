package com.vaccsmonitor.vaccsmonitorsql;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.vaccsmonitor.vaccsmonitorsql.model.DayVacs;
import com.vaccsmonitor.vaccsmonitorsql.model.Region;
import com.vaccsmonitor.vaccsmonitorsql.repositories.DayVacsRepository;
import com.vaccsmonitor.vaccsmonitorsql.repositories.RegionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Configuration
@Slf4j
class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(RegionRepo repository, DayVacsRepository DVrepository) {
        return args -> {
            log.info("Preloading data");
            Map<Long, Region> regionMap = new HashMap<Long, Region>();

            String fileNameRegions = "data\\populationRegionalUnits.csv";
            File f = new File(fileNameRegions);
            String absolute_path = f.getAbsolutePath();

            try (CSVReader reader = new CSVReader(new FileReader(absolute_path))) {
                List<String[]> r = reader.readAll();
                r.remove(0);

                for (String[] x: r) {
                    Region newRegion = new Region(Long.parseLong(x[0]),x[1],Integer.parseInt(x[2].replace(".","")));
                    regionMap.put(Long.parseLong(x[0]), newRegion);
                }

            } catch (IOException | CsvException e) {
                throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
            }

            List<DayVacs> dataArray = new ArrayList<DayVacs>();

            String fileNameDayVacs = "data\\covidStats.csv";
            f = new File(fileNameDayVacs);
            absolute_path = f.getAbsolutePath();

            try (CSVReader reader = new CSVReader(new FileReader(absolute_path))) {
                List<String[]> r = reader.readAll();
                r.remove(0);

                for (String[] x: r) {
                    Region region = regionMap.get(Long.parseLong(x[1]));
                    region.setTotalVaccination(region.getTotalVaccination()+Integer.parseInt(x[2]));
                    DayVacs newEntity = new DayVacs(x[6],region,Integer.parseInt(x[10]));
                    dataArray.add(newEntity);
                }

            } catch (IOException | CsvException e) {
                throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
            }

            for(Region r: regionMap.values()){
                repository.save(r);
            }
            log.info("Regions saved");

            for(DayVacs d: dataArray){
                DVrepository.save(d);
            }
            log.info("Days of each vaccination per region saved");
        };
    }
}
