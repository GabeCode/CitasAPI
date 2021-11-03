package com.gabrego.citasapi.service;

import com.gabrego.citasapi.entity.Clinic;

import java.util.List;

public interface ClinicService {
    public List<Clinic> findAll();

    public Clinic findById(int id);

    public List<Clinic> findByDepartment(int id);

    public void save(Clinic clinic);

    public int deleteById(int id);
}
