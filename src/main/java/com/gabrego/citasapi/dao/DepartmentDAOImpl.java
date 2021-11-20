package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Department;
import com.gabrego.citasapi.entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class DepartmentDAOImpl implements DepartmentDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Department> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Department> theQuery = currentSession.createQuery("FROM Department ", Department.class);
        List<Department> departments = theQuery.getResultList();
        return departments;
    }

    @Override
    public Department findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Department department = currentSession.get(Department.class, id);
        return department;
    }

    @Override
    public void save(Department department) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(department);
        transaction.commit();
    }

    @Transactional
    @Override
    public int deleteById(int id) {
        return 0;
    }


}
