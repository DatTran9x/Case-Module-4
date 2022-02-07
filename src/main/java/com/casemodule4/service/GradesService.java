package com.casemodule4.service;

import com.casemodule4.model.Grades;
import com.casemodule4.repository.GradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradesService implements IGradesService{

    @Autowired
    GradesRepository gradeRepository;

    @Override
    public List<Grades> findAll() {
        return (List<Grades>) gradeRepository.findAll();
    }

    @Override
    public void save(Grades grades) {
        gradeRepository.save(grades);
    }

    @Override
    public void delete(int id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public Optional<Grades> findById(int id) {
        return gradeRepository.findById(id);
    }
}
