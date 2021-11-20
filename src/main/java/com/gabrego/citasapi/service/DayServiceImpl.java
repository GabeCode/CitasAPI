package com.gabrego.citasapi.service;

import com.gabrego.citasapi.dao.DayDAO;
import com.gabrego.citasapi.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayDAO dayDAO;

    @Override
    public List<Day> findAll() {
        return dayDAO.findAll();
    }

    @Override
    public Day findById(int id) {
        return dayDAO.findById(id);
    }

    @Override
    public void save(Day day) {
        dayDAO.save(day);
    }

    @Override
    public int deleteById(int id) {
        return dayDAO.deleteById(id);
    }
}
