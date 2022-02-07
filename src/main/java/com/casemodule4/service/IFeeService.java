package com.casemodule4.service;

import com.casemodule4.model.Fee;

import java.util.List;

public interface IFeeService {
    List<Fee> findAll();
    void save(Fee fee);
    void delete(int id);
    Fee findById(int id);
}
