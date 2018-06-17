package com.example.company.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer companyId;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="address")
    private String address;

    @NotNull
    @Column(name="city")
    private String city;

    @NotNull
    @Column(name="country")
    private String country;

    @Column(name="email")
    private String email;// (not required)

    @Column(name="phoneNumber")
    private String phoneNumber;// (not required)
/*

    private List<Owner> owners;*/

}
