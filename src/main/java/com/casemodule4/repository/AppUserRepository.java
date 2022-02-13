package com.casemodule4.repository;

import com.casemodule4.model.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    List<AppUser> findAllByNameContaining(String name);
    AppUser findByEmail(String email);


    @Query (nativeQuery = true, value = "select * from app_user join classroom on app_user.classrooms_id_class_room = classroom.id_class_room where app_user.classrooms_id_class_room =:idClassRoom")
    List<AppUser> findAllByClassrooms(@Param( "idClassRoom") int idClassRoom);
}
