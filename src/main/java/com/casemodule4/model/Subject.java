package com.casemodule4.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
public class Subject {
    @Id
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Grades> grades;
}
