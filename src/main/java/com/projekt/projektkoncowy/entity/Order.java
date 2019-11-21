package com.projekt.projektkoncowy.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date;

    @OneToMany(mappedBy = "order")
    private Set<OrderLine> orderLines;


    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;




//    @ManyToMany //(optional = false)
//    @JoinColumn(name = "orderline_id")
//    private OrderLine orderLine;

}
