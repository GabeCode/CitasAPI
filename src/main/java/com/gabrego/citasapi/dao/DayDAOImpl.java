package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Day;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class DayDAOImpl implements DayDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Day> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Day> theQuery = currentSession.createQuery("FROM Day ", Day.class);
        List<Day> days = theQuery.getResultList();
        return days;
    }

    @Override
    public Day findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Day day = currentSession.get(Day.class, id);
        return day;
    }

    @Override
    public void save(Day day) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(day);
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        return 0;
    }


}
