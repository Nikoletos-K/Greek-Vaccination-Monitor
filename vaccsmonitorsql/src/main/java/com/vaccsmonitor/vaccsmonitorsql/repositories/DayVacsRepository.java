package com.vaccsmonitor.vaccsmonitorsql.repositories;

import com.vaccsmonitor.vaccsmonitorsql.model.DayVacs;
import com.vaccsmonitor.vaccsmonitorsql.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DayVacsRepository extends JpaRepository<DayVacs, Long> {
    Optional<DayVacs> findDayVacsById(Long id);


}
