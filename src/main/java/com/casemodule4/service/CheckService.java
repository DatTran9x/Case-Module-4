package com.casemodule4.service;

import com.casemodule4.model.AppUser;
import com.casemodule4.model.RollCall;
import com.casemodule4.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Service
public class CheckService implements ICheckService{

    @Autowired
    CheckRepository checkRepository;

    @Override
    public List<RollCall> findAll() {
        return (List<RollCall>) checkRepository.findAll();
    }

    @Override
    public void save(RollCall rollCall) {
        checkRepository.save(rollCall);
    }

    @Override
    public void delete(int id) {
        checkRepository.deleteById(id);
    }

    @Override
    public RollCall findById(int id) {
        return checkRepository.findById(id).get();
    }

    @Override
    public List<RollCall> findAllByDate(Date date) {
        return checkRepository.findAllByDateLike(date);
    }

    @Override
    public Boolean checkIfChecked(AppUser appUser) {
        Set<RollCall> set = appUser.getRollCall();
        for (RollCall rollCall : set) {
            Date date = new Date(System.currentTimeMillis());
            System.out.println(date);
            if(rollCall.getDate().equals(date)){
                if(rollCall.isChecked()){
                    return true;
                }
            }
        }
        return false;
    }
}
