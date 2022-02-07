package com.casemodule4.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Grades {
    @Id
    private int id;
    private double theoreticalPoint;
    private double practicePoint;
    private double averagePoint;
    private Date dateOfTest;
}
