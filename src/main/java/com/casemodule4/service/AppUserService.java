package com.casemodule4.service;

import com.casemodule4.model.AppUser;
import com.casemodule4.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService{
    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAppUserList() {
        return (List<AppUser>) appUserRepository.findAll();
    }

    @Override
    public void addAppUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void deleteAppUser(int id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public Optional<AppUser> getAppUserById(int id) {
        return appUserRepository.findById(id);
    }

    @Override
    public List<AppUser> findAppUserByName(String name) {
        return appUserRepository.findAllByNameContaining(name);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        AppUser appUser = appUserRepository.findByEmail(email);
        return new User(appUser.getEmail(),appUser.getPassword(),appUser.getRoles());
    }

    @Override
    public AppUser findAppUserByEmail(String getEmail) {
        AppUser appUser = appUserRepository.findByEmail(getEmail);
        return appUser;
    }

}
