package com.casemodule4.repository;

import com.casemodule4.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    List<AppUser> findAllByNameContaining(String name);
    AppUser findByEmail(String email);

}
