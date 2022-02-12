package com.casemodule4.repository;

import com.casemodule4.model.RollCall;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface CheckRepository extends CrudRepository<RollCall,Integer> {
    List<RollCall> findAllByDateLike(Date date);
}
