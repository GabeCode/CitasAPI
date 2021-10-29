package com.gabrego.citasapi.service;

import com.gabrego.citasapi.entity.DoctorSchedule;

import java.util.List;

public interface DoctorScheduleService {

    public List<DoctorSchedule> findAll();

    public DoctorSchedule findById(int id);

    public void save(DoctorSchedule doctorSchedule);

    public int deleteById(int id);
}
