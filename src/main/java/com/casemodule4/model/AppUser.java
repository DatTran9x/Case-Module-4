package com.casemodule4.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String name;
    @Email
    private String email;
    @Size(min=6,max=8,message="Min 6,max 8")
    private String password;
    @Size(min=10,max=12,message="Min 10,max 12")
    private String phone;
    @NotEmpty
    private String fullName;
    @NotEmpty
    private Date dateOfBirth;
    @NotEmpty
    private String address;
    @NotEmpty
    private String identity;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Classroom> classroom;

    @ManyToOne
    private AppUserStatus appUserStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Fee> fee;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Diary> diary;
}