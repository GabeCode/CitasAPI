package com.gabrego.citasapi.service;

import com.gabrego.citasapi.entity.Day;

import java.util.List;

public interface DayService{
    public List<Day> findAll();

    public Day findById(int id);

    public void save(Day day);

    public int deleteById(int id);
}
