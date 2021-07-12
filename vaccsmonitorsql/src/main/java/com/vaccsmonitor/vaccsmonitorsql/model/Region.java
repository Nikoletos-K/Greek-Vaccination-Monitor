package com.vaccsmonitor.vaccsmonitorsql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "region")
public class Region implements Serializable {

    @Id
    @Column(name="id",nullable=false,updatable=false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "population", nullable = false)
    private Integer population;

    @OneToMany(mappedBy="region",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DayVacs> dayVacs;

    @Column(name = "totalVaccination")
    private Integer totalVaccination=0;

    @Column(name = "vaccinationPercentage")
    private Double vaccinationPercentage;

    public Region() {}

    public Region(Long id, String name, Integer population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public List<DayVacs> getDayVacs() {
        return dayVacs;
    }
    public Double getVaccinationPercentage() {
        return vaccinationPercentage;
    }

    public void setVaccinationPercentage(Double vaccinationPercentage) {
        this.vaccinationPercentage = vaccinationPercentage;
    }

    public Integer getTotalVaccination() {
        return totalVaccination;
    }

    public void setTotalVaccination(Integer totalVaccination) {
        this.totalVaccination = totalVaccination;
        this.setVaccinationPercentage((double) this.totalVaccination/this.population);
    }

    public void setDayVacs(List<DayVacs> dayVacs) {
        this.dayVacs = dayVacs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
