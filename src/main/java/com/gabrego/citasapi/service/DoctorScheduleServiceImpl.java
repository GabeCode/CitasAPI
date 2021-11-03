package com.gabrego.citasapi.service;

import com.gabrego.citasapi.dao.DoctorScheduleDAO;
import com.gabrego.citasapi.entity.DoctorSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {
    @Autowired
    private DoctorScheduleDAO doctorScheduleDAO;


    @Override
    public List<DoctorSchedule> findAll() {
        return doctorScheduleDAO.findAll();
    }

    @Override
    public List<DoctorSchedule> findByDoctorId(int id) {
        return doctorScheduleDAO.findByDoctorId(id);
    }

    @Override
    public List<DoctorSchedule> findAvailabilityByDoctorAndDate(int id, Date date) {
        return doctorScheduleDAO.findAvailabilityByDoctorAndDate(id, date);
    }

    @Override
    public DoctorSchedule findById(int id) {
        return doctorScheduleDAO.findById(id);
    }

    @Override
    public void save(DoctorSchedule doctorSchedule) {
        doctorScheduleDAO.save(doctorSchedule);
    }

    @Override
    public int deleteById(int id) {
        return doctorScheduleDAO.deleteById(id);
    }
}
