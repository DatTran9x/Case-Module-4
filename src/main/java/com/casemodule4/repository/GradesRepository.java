package com.casemodule4.repository;

import com.casemodule4.model.Grades;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradesRepository extends CrudRepository<Grades,Integer> {
    @Query(nativeQuery = true,value = "select  * from app_user au right join app_user_classroom auc on au.id=auc.app_user_id right join classroom c on auc.classroom_id = c.id right join classroom_subject cs on c.id = cs.classroom_id right join subject s on cs.subject_id = s.id join subject_grades sg on s.id = sg.subject_id join grades g on sg.grades_id = g.id where au.id=:id")
    List<Grades> findAllByUserId(@Param("id") int id);
}
