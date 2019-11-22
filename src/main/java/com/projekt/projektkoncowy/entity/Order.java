package com.projekt.projektkoncowy.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
  //  @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;


    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;





//    @ManyToMany //(optional = false)
//    @JoinColumn(name = "orderline_id")
//    private OrderLine orderLine;

}

