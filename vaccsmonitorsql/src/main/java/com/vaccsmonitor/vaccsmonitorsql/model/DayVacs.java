package com.vaccsmonitor.vaccsmonitorsql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "dayVacs")
public class DayVacs {

    @Id
    @Column(name="id",nullable=false,updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date", nullable = false)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Region region;

    @Column(name = "totalVaccinations", nullable = false)
    private Integer totalVaccinations;

    public DayVacs() {}

    public DayVacs(String date, Region region, Integer totalVaccinations) {
        this.date = date;
        this.region = region;
        this.totalVaccinations = totalVaccinations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Integer getTotalVaccinations() {
        return totalVaccinations;
    }

    public void setTotalVaccinations(Integer totalVaccinations) {
        this.totalVaccinations = totalVaccinations;
    }

    @Override
    public String toString() {
        return "DayVacs{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", region=" + region +
                ", totalVaccinations=" + totalVaccinations +
                '}';
    }
}
