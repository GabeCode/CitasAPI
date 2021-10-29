package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Doctor;

import java.util.List;

public interface DoctorDAO {
    public List<Doctor> findAll();

    public Doctor findById(int id);

    public Doctor findByUserId(int id);

    public void save(Doctor doctor);

    public int deleteById(int id);

    public int deleteByUserId(int id);
}
