package com.vaccsmonitor.vaccsmonitorsql;

import com.vaccsmonitor.vaccsmonitorsql.model.DayVacs;
import com.vaccsmonitor.vaccsmonitorsql.model.Region;
import com.vaccsmonitor.vaccsmonitorsql.service.DayVacsService;
import com.vaccsmonitor.vaccsmonitorsql.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//public class DayVacsController {
  //  private final DayVacsService dayVacsService;

    //public DayVacsController(DayVacsService dayVacsService) {
    //    this.dayVacsService = dayVacsService;
   // }

   // @GetMapping("/find/dates/{id}")
   // public ResponseEntity<List<DayVacs>>  getDayVacsByRegion(@PathVariable("id") Long id) {
   //     List<DayVacs> dayVacs = dayVacsService.getDayVacsByRegion(id);
   //     return new ResponseEntity<>(dayVacs, HttpStatus.OK);
    //}

//}
