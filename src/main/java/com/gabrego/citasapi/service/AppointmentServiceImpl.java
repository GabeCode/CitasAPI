package com.gabrego.citasapi.service;

import com.gabrego.citasapi.dao.AppointmentDAO;
import com.gabrego.citasapi.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentDAO appointmentDAO;

    @Override
    public List<Appointment> findAll() {
        return appointmentDAO.findAll();
    }

    @Override
    public List<Appointment> findByPatientId(int id) {
        return appointmentDAO.findByPatientId(id);
    }

    @Override
    public Appointment findById(int id) {
        return appointmentDAO.findById(id);
    }

    @Override
    public void save(Appointment appointment) {
        appointmentDAO.save(appointment);
    }

    @Override
    public int deleteById(int id) {
        return appointmentDAO.deleteById(id);
    }
}
