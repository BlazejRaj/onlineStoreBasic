package com.projekt.projektkoncowy.entity;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;


@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 4000)
    private String description;

    private String productType;

    private int prize;

    @ManyToOne //(optional = false)
    @JoinColumn(name = "user_id")
    private User user;





}