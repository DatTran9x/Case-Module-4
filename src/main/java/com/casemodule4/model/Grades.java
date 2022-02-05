package com.casemodule4.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Grades implements GrantedAuthority {
    @Id
    private int id;
    private double theoreticalPoint;
    private double practicePoint;
    private double averagePoint;

    @Override
    public String getAuthority() {
        return null;
    }
}
