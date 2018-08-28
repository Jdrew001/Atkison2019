package com.atkison.atkison2018.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reserved")
public class Reserved {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reserved_id")
    @Id
    private Integer id;

    @Column(name = "firstname")
    @NotNull
    @NotEmpty(message = "Please provide a first name")
    private String firstname;

    @Column(name = "lastname")
    @NotNull
    @NotEmpty(message = "Please provide a last name")
    private String lastname;

    @Column(name = "partyNumberCeremony")
    @NotNull
    @NotEmpty(message = "Please provide the number in your party attending the ceremony")
    private int partyNumberCeremony;

    @Column(name = "partyNumberReception")
    @NotNull
    @NotEmpty(message = "Please provide the number in your party attending the reception")
    private int partyNumberReception;
}
