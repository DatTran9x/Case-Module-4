package com.casemodule4.repository;

import com.casemodule4.model.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends CrudRepository<Classroom,Integer> {
}
