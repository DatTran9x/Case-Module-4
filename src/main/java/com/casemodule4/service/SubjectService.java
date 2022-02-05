package com.casemodule4.service;

import com.casemodule4.model.Subject;
import com.casemodule4.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService{
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return (List<Subject>) subjectRepository.findAll();
    }

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void delete(int id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Optional<Subject> findById(int id) {
        return subjectRepository.findById(id);
    }
}
