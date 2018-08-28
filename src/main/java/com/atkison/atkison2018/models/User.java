package com.atkison.atkison2018.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Id
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
