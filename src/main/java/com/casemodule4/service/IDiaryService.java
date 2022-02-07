package com.casemodule4.service;

import com.casemodule4.model.Diary;

import java.util.List;
import java.util.Optional;

public interface IDiaryService {
    List<Diary> findAll();
    void save(Diary diary);
    void delete(int id);
    Optional<Diary> findById(int id);
}
