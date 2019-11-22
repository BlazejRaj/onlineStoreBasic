package com.projekt.projektkoncowy.entity;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Set;


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

//    @Column
//    private String productType;

    @Column
    private int prize;

//    @OneToMany(mappedBy = "product")
//    private Set<OrderLine> orderLines;

}
