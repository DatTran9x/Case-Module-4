package com.casemodule4.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Data
public class Subject {
    @Id
    private int id;
    @NotEmpty(message="Not empty")
    private String name;

    @ManyToMany
    private Set<Grades> grades;
}
