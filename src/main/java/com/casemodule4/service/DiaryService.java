package com.casemodule4.service;

import com.casemodule4.model.Diary;
import com.casemodule4.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaryService implements IDiaryService{
    @Autowired
    DiaryRepository diaryRepository;

    @Override
    public List<Diary> findAll() {
        return (List<Diary>) diaryRepository.findAll();
    }

    @Override
    public void save(Diary diary) {
        diaryRepository.save(diary);
    }

    @Override
    public void delete(int id) {
        diaryRepository.deleteById(id);
    }

    @Override
    public Optional<Diary> findById(int id) {
        return diaryRepository.findById(id);
    }
}
