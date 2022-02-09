package com.casemodule4.service;

import com.casemodule4.model.Grades;

import java.util.List;
import java.util.Optional;

public interface IGradesService {
    List<Grades> findAll();
    void save(Grades grades);
    void delete(int id);
    Optional<Grades> findById(int id);
    Object findAllByUserId(int id);
}
