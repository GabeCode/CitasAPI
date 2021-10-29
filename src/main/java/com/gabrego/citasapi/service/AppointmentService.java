package com.gabrego.citasapi.service;

import com.gabrego.citasapi.entity.Appointment;
import com.gabrego.citasapi.entity.User;

import java.util.List;

public interface AppointmentService {
    public List<Appointment> findAll();

    public List<Appointment> findByPatientId(int id);

    public Appointment findById(int id);

    public void save(Appointment appointment);

    public int deleteById(int id);
}
