package com.casemodule4.service;

import com.casemodule4.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findById(int id);
}
