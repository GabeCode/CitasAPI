package com.gabrego.citasapi.dao;

import com.gabrego.citasapi.entity.Day;

import java.util.List;

public interface DayDAO {
    public List<Day> findAll();

    public Day findById(int id);

    public void save(Day day);

    public int deleteById(int id);
}
