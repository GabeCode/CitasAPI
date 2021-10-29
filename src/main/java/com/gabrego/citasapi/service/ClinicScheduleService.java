package com.gabrego.citasapi.service;

import com.gabrego.citasapi.entity.ClinicSchedule;

import java.util.List;

public interface ClinicScheduleService {
    public List<ClinicSchedule> findAll();

    public ClinicSchedule findById(int id);

    public void save(ClinicSchedule clinicSchedule);

    public int deleteById(int id);
}
