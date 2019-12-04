package com.projekt.projektkoncowy.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String houseNo;

    @Column
    private String postalCode;

}
