package com.gabrego.citasapi.service;

import com.gabrego.citasapi.dao.ClinicScheduleDAO;
import com.gabrego.citasapi.entity.ClinicSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicScheduleServiceImpl implements ClinicScheduleService {

    @Autowired
    private ClinicScheduleDAO clinicScheduleDAO;

    @Override
    public List<ClinicSchedule> findAll() {
        return clinicScheduleDAO.findAll();
    }

    @Override
    public ClinicSchedule findById(int id) {
        return clinicScheduleDAO.findById(id);
    }

    @Override
    public void save(ClinicSchedule clinicSchedule) {
        clinicScheduleDAO.save(clinicSchedule);
    }

    @Override
    public int deleteById(int id) {
        return clinicScheduleDAO.deleteById(id);
    }
}
