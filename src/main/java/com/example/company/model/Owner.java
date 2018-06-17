package com.example.company.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;

    @Column(name="name")
    private String name;
}
