package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.DoctorSchedule;

import java.sql.Date;
import java.util.List;

public interface DoctorScheduleDAO {
    public List<DoctorSchedule> findAll();

    public  List<DoctorSchedule> findByDoctorId(int id);

    public List<DoctorSchedule> findAvailabilityByDoctorAndDate(int id, Date date);

    public DoctorSchedule findById(int id);

    public void save(DoctorSchedule doctorSchedule);

    public int deleteById(int id);
}
