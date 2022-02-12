package com.casemodule4.service;

import com.casemodule4.model.AppUser;
import com.casemodule4.model.RollCall;

import java.sql.Date;
import java.util.List;

public interface ICheckService {
    List<RollCall> findAll();
    void save(RollCall rollCall);
    void delete(int id);
    RollCall findById(int id);
    List<RollCall> findAllByDate(Date date);
    Boolean checkIfChecked(AppUser appUser);
}
