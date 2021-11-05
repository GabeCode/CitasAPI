package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Days;
import com.gabrego.citasapi.entity.Doctor;
import com.gabrego.citasapi.entity.DoctorSchedule;
import com.gabrego.citasapi.entity.DoctorSchedule;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Calendar;
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
    public List<DoctorSchedule> findByDoctorId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<DoctorSchedule> theQuery = currentSession.createQuery("FROM DoctorSchedule WHERE doctor_id.id=:idDoctor", DoctorSchedule.class);
        theQuery.setParameter("idDoctor", id);
        List<DoctorSchedule> doctorSchedules = theQuery.getResultList();
        return doctorSchedules;
    }

    @Override
    public List<DoctorSchedule> findAvailabilityByDoctorAndDate(int id, Date date) {
        Session currentSession = entityManager.unwrap(Session.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayWeek=0;
        Query<DoctorSchedule> theQuery = currentSession.createQuery("FROM DoctorSchedule AS ds WHERE ds.doctor_id.id=:idDoctor " +
                " AND ds.day_id.id=:idDay", DoctorSchedule.class);
        theQuery.setParameter("idDoctor", id);

        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                dayWeek = Days.SUNDAY.getDayId();
                break;
            case 2:
                dayWeek = Days.MONDAY.getDayId();
                break;
            case 3:
                dayWeek = Days.TUESDAY.getDayId();
                break;
            case 4:
                dayWeek = Days.WEDNESDAY.getDayId();
                break;
            case 5:
                dayWeek = Days.THURSDAY.getDayId();
                break;
            case 6:
                dayWeek = Days.FRIDAY.getDayId();
                break;
            case 7:
                dayWeek = Days.SATURDAY.getDayId();
                break;
            default:
                break;
        }
        theQuery.setParameter("idDay", dayWeek);
        return theQuery.getResultList();
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
