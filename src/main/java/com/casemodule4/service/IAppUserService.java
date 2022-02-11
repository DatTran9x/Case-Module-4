package com.casemodule4.service;

import com.casemodule4.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface IAppUserService extends UserDetailsService {
    List<AppUser> getAppUserList();
    void addAppUser(AppUser appUser);
    void deleteAppUser(int id);
    Optional<AppUser> getAppUserById(int id);
    List<AppUser> findAppUserByName(String name);
    UserDetails loadUserByUsername(String email);
    AppUser findAppUserByEmail(String getEmail);
    void save(AppUser appUser);
}
