package com.projekt.projektkoncowy.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

//    @Enumerated(EnumType.STRING)
//    private UserRole userRole;


}
