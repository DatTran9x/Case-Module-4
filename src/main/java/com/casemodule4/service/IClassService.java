package com.casemodule4.service;

import com.casemodule4.model.Classroom;

import java.util.List;
import java.util.Optional;

public interface IClassService {
    List<Classroom> findAll();
    void save(Classroom CLass);
    void delete(int id);
    Optional<Classroom> findById(int id);
}
