package com.casemodule4.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class AppUserStatus  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatus;
    private String name;
}
