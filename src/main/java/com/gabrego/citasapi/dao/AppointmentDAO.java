package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Appointment;

import java.util.List;

public interface AppointmentDAO {
    public List<Appointment> findAll();

    public List<Appointment> findByPatientId(int id);

    public Appointment findById(int id);

    public void save(Appointment appointment);

    public int deleteById(int id);
}
