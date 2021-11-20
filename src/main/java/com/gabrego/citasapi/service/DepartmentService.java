package com.gabrego.citasapi.service;

import com.gabrego.citasapi.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> findAll();

    public Department findById(int id);

    public void save(Department day);

    public int deleteById(int id);
}
