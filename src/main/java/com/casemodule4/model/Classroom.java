package com.casemodule4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Classroom  {
    @Id
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Subject> subject;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Diary> diary;
}
