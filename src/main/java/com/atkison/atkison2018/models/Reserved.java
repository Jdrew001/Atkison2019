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
    private String partyNumberCeremony;

    @Column(name = "partyNumberReception")
    @NotNull
    private String partyNumberReception;

    public Reserved() { }

    public Reserved(Reserved reserved)
    {
        this.firstname = reserved.firstname;
        this.lastname = reserved.lastname;
        this.partyNumberCeremony = reserved.partyNumberCeremony;
        this.partyNumberReception = reserved.partyNumberReception;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPartyNumberCeremony() {
        return partyNumberCeremony;
    }

    public void setPartyNumberCeremony(String partyNumberCeremony) {
        this.partyNumberCeremony = partyNumberCeremony;
    }

    public String getPartyNumberReception() {
        return partyNumberReception;
    }

    public void setPartyNumberReception(String partyNumberReception) {
        this.partyNumberReception = partyNumberReception;
    }
}
