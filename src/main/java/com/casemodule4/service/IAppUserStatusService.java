package com.casemodule4.service;

import com.casemodule4.model.AppUserStatus;

import java.util.List;

public interface IAppUserStatusService {
    List<AppUserStatus> findAll();
    AppUserStatus finById(int id);
}
