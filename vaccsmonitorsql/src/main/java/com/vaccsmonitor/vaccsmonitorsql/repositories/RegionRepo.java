package com.vaccsmonitor.vaccsmonitorsql.repositories;

import com.vaccsmonitor.vaccsmonitorsql.model.Region;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegionRepo extends JpaRepository<Region, Long> {

    Optional<Region> findRegionById(Long id);
}
