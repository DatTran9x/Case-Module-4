package com.casemodule4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Classroom {
    @Id
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Subject subject;

}
