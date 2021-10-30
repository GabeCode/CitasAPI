package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.DoctorSchedule;

import java.util.List;

public interface DoctorScheduleDAO {
    public List<DoctorSchedule> findAll();

    public  List<DoctorSchedule> findByDoctorId(int id);

    public DoctorSchedule findById(int id);

    public void save(DoctorSchedule doctorSchedule);

    public int deleteById(int id);
}
