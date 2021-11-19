package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Clinic;
import com.gabrego.citasapi.entity.ClinicSchedule;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClinicScheduleDAOImpl implements ClinicScheduleDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ClinicSchedule> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ClinicSchedule> theQuery = currentSession.createQuery("FROM ClinicSchedule", ClinicSchedule.class);
        List<ClinicSchedule> clinicSchedules = theQuery.getResultList();
        return clinicSchedules;
    }

    @Override
    public ClinicSchedule findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        ClinicSchedule clinicSchedule = currentSession.get(ClinicSchedule.class, id);
        return clinicSchedule;
    }

    @Override
    public void save(ClinicSchedule clinicSchedule) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(clinicSchedule);
        transaction.commit();
    }

    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ClinicSchedule> theQuery = currentSession.createQuery("DELETE FROM ClinicSchedule WHERE id=:idClinicSchedule");
        theQuery.setParameter("idClinicSchedule", id);
        return theQuery.executeUpdate();
    }
}
