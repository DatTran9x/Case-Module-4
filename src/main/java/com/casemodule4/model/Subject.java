package com.casemodule4.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Subject implements GrantedAuthority {
    @Id
    private int id;
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    @OneToOne
    private Grades grades;
}
