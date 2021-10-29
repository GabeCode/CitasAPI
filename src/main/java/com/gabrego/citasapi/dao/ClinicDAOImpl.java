package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Clinic;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClinicDAOImpl implements ClinicDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Clinic> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Clinic> theQuery = currentSession.createQuery("FROM Clinic", Clinic.class);
        List<Clinic> clinics = theQuery.getResultList();
        return clinics;
    }

    @Override
    public Clinic findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Clinic clinic = currentSession.get(Clinic.class, id);
        return clinic;
    }

    @Override
    public List<Clinic> findByDepartment(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Clinic> theQuery = currentSession.createQuery("FROM Clinic WHERE department_id.id=:idDepa", Clinic.class);
        theQuery.setParameter("idDepa", id);
        return theQuery.getResultList();
    }

    @Override
    public void save(Clinic clinic) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(clinic);
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Clinic> theQuery = currentSession.createQuery("DELETE FROM Clinic WHERE id=:idClinic");
        theQuery.setParameter("idClinic", id);
        return theQuery.executeUpdate();
    }
}
