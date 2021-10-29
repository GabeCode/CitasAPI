package com.gabrego.citasapi.service;


import com.gabrego.citasapi.entity.MedicalRecord;

import java.util.List;

public interface MedicalService {

    public List<MedicalRecord> findAll();

    public MedicalRecord findById(int id);

    public MedicalRecord findByUserId(int id);

    public void save(MedicalRecord medicalRecord);

    public int deleteById(int id);

    public int deleteByUserId(int id);
}
