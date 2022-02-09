package com.casemodule4.service;

import com.casemodule4.model.Subject;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {
    List<Subject> findAll();
    void save(Subject subject);
    void delete(int id);
    Optional<Subject> findById(int id);
    List<Subject> findAllByUserId(int id);
    Subject findSubjectByGradeId(int id);
}
