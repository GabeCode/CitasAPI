package com.gabrego.citasapi.service;

import com.gabrego.citasapi.dao.ClinicDAO;
import com.gabrego.citasapi.entity.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService{

    @Autowired
    private ClinicDAO clinicDAO;

    @Override
    public List<Clinic> findAll() {
        return clinicDAO.findAll();
    }

    @Override
    public Clinic findById(int id) {
        return clinicDAO.findById(id);
    }

    @Override
    public List<Clinic> findByDepartment(int id) {
        return clinicDAO.findByDepartment(id);
    }

    @Override
    public void save(Clinic clinic) {
        clinicDAO.save(clinic);
    }

    @Override
    public int deleteById(int id) {
        return clinicDAO.deleteById(id);
    }
}
