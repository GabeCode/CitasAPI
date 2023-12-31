package com.gabrego.citasapi.service;

import com.gabrego.citasapi.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(int id);

    public User findByEmail(String email);

    public void save(User user);

    public void deleteById(int id);
}
