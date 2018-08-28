package com.atkison.atkison2018.models;

import javax.persistence.*;

@Entity
@Table(name = "alert")
public class Alert {

    @Column(name = "alert_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "email")
    private String email;
}
