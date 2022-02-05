package com.casemodule4.service;

import com.casemodule4.model.Classroom;
import com.casemodule4.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService implements IClassService{

    @Autowired
    ClassRepository classRepository;

    @Override
    public List<Classroom> findAll() {
        return (List<Classroom>) classRepository.findAll();
    }

    @Override
    public void save(Classroom CLass) {
        classRepository.save(CLass);
    }

    @Override
    public void delete(int id) {
        classRepository.deleteById(id);
    }

    @Override
    public Optional<Classroom> findById(int id) {
        return classRepository.findById(id);
    }
}
