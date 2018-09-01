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

    public User() {}

    public User(User user) {
        this.id = user.id;
        this.email = user.email;
        this.password = user.password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
