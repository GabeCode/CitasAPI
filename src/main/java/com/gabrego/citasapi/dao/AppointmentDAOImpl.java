package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Appointment;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Appointment> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Appointment> theQuery = currentSession.createQuery("FROM Appointment", Appointment.class);
        List<Appointment> appointments = theQuery.getResultList();
        return appointments;
    }

    @Override
    public List<Appointment> findByPatientId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Appointment> theQuery = currentSession.createQuery("FROM Appointment WHERE patient_id.id=:patientId", Appointment.class);
        theQuery.setParameter("patientId", id);
        List<Appointment> appointments = theQuery.getResultList();
        return appointments;
    }

    @Override
    public Appointment findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Appointment appointment = currentSession.get(Appointment.class, id);
        return appointment;
    }

    @Override
    public Appointment checkIfExistTimeAndDate(int idDoctor, Date aDate, Time timeStart, Time timeFinish) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Appointment> theQuery = currentSession.createQuery("FROM Appointment WHERE doctor_id.id=:doctorId AND appointment_date=:dateA AND " +
                "appointment_time=:sTime AND appointment_time_finish=:fTime AND status.id=1", Appointment.class);
        theQuery.setParameter("doctorId", idDoctor);
        theQuery.setParameter("dateA", aDate);
        theQuery.setParameter("sTime", timeStart);
        theQuery.setParameter("fTime", timeFinish);
        return theQuery.uniqueResult();
    }


    @Override
    public void save(Appointment appointment) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(appointment);
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Appointment> theQuery = currentSession.createQuery("DELETE FROM Appointment WHERE id=:idAppointment");
        theQuery.setParameter("idAppointment", id);
        return theQuery.executeUpdate();
    }
}
