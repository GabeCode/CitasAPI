package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Doctor;
import com.gabrego.citasapi.entity.DoctorSchedule;
import com.gabrego.citasapi.entity.DoctorSchedule;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DoctorScheduleDAOImpl implements DoctorScheduleDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<DoctorSchedule> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<DoctorSchedule> theQuery = currentSession.createQuery("FROM DoctorSchedule", DoctorSchedule.class);
        List<DoctorSchedule> doctorSchedules = theQuery.getResultList();
        return doctorSchedules;
    }

    @Override
    public DoctorSchedule findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        DoctorSchedule doctorSchedule = currentSession.get(DoctorSchedule.class, id);
        return doctorSchedule;
    }

    @Override
    public void save(DoctorSchedule doctorSchedule) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(doctorSchedule);
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<DoctorSchedule> theQuery = currentSession.createQuery("DELETE FROM DoctorSchedule WHERE id=:idDoctorSchedule");
        theQuery.setParameter("idDoctorSchedule", id);
        return theQuery.executeUpdate();
    }
}
