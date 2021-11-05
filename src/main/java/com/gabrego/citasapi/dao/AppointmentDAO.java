package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Appointment;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AppointmentDAO {
    public List<Appointment> findAll();

    public List<Appointment> findByPatientId(int id);

    public Appointment findById(int id);

    public Appointment checkIfExistTimeAndDate(int idDoctor, Date aDate, Time timeStart, Time timeFinish);

    public void save(Appointment appointment);

    public int deleteById(int id);
}
