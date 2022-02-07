package com.casemodule4.repository;

import com.casemodule4.model.Grades;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends CrudRepository<Grades,Integer> {
}
