package com.atkison.atkison2018.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ipaddress")
public class Ipaddress {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ip_id")
    @Id
    private Integer id;

    @Column(name = "ip")
    @NotNull
    private String ipAddress;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "latitude")
    @NotNull
    private String latitude;

    @Column(name = "longitude")
    @NotNull
    private String longitude;

    @Column(name = "postal")
    @NotNull
    private String postal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserved_id")
    private Reserved reserved;

    public Ipaddress() { }

    public Ipaddress(Ipaddress ipaddress) {
        this.id = ipaddress.id;
        this.ipAddress = ipaddress.ipAddress;
        this.city = ipaddress.city;
        this.latitude = ipaddress.latitude;
        this.longitude = ipaddress.longitude;
        this.postal = ipaddress.postal;
        this.reserved = ipaddress.reserved;
    }

    public Ipaddress(String ipAddress, String city, String latitude, String longitude, String postal, Reserved reserved) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postal = postal;
        this.reserved = reserved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public Reserved getReserved() {
        return reserved;
    }

    public void setReserved(Reserved reserved) {
        this.reserved = reserved;
    }
}
