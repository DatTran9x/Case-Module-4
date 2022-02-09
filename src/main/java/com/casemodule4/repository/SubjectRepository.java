package com.casemodule4.repository;

import com.casemodule4.model.Grades;
import com.casemodule4.model.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Integer> {
    @Query(nativeQuery = true,value = "select  distinct s.* from subject s join classroom_subject cs on cs.subject_id = s.id join subject_grades sg on s.id = sg.subject_id join grades g on sg.grades_id = g.id join app_user au right join app_user_classroom auc on au.id=auc.app_user_id right join classroom c on auc.classroom_id = c.id where au.id=:id")
    List<Subject> findAllByUserId(@Param("id") int id);

    @Query(nativeQuery = true,value = "select distinct s.* from subject s join subject_grades sg on s.id = sg.subject_id join grades g on sg.grades_id = g.id where g.id=1;")
    Subject findSubjectByGradeId(@Param("id") int id);

}
