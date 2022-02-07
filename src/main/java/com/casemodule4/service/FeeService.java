package com.casemodule4.service;

import com.casemodule4.model.Fee;
import com.casemodule4.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService implements IFeeService {
    @Autowired
    FeeRepository feeRepository;

    @Override
    public List<Fee> findAll() {
        return (List<Fee>) feeRepository.findAll();
    }

    @Override
    public void save(Fee fee) {
        feeRepository.save(fee);
    }

    @Override
    public void delete(int id) {
        feeRepository.deleteById(id);
    }

    @Override
    public Fee findById(int id) {
        return feeRepository.findById(id).get();
    }
}
