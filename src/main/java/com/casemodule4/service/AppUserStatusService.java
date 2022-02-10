package com.casemodule4.service;

import com.casemodule4.model.AppUserStatus;
import com.casemodule4.repository.AppUserRepository;
import com.casemodule4.repository.AppUserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppUserStatusService implements IAppUserStatusService{
    @Autowired
    AppUserStatusRepository appUserStatusRepository;
    @Override
    public List<AppUserStatus> findAll() {
        return (List<AppUserStatus>) appUserStatusRepository.findAll();
    }

    @Override
    public AppUserStatus finById(int id) {
        return appUserStatusRepository.findById(id).get();
    }
}
