package com.gabrego.citasapi.service;

import com.gabrego.citasapi.dao.DepartmentDAO;
import com.gabrego.citasapi.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public List<Department> findAll() {
        return departmentDAO.findAll();
    }

    @Override
    public Department findById(int id) {
        return departmentDAO.findById(id);
    }

    @Override
    public void save(Department department) {
        departmentDAO.save(department);
    }

    @Override
    public int deleteById(int id) {
        return departmentDAO.deleteById(id);
    }
}
