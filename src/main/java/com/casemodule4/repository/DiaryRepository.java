package com.casemodule4.repository;

import com.casemodule4.model.Diary;
import org.springframework.data.repository.CrudRepository;

public interface DiaryRepository extends CrudRepository<Diary,Integer> {
}
