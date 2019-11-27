package com.projekt.projektkoncowy.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "orderlines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    @ManyToOne (cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id")
//    private Order order;



   // fetch = FetchType.LAZY





//    @ManyToOne //(optional = false)
//    @JoinColumn(name = "order_id")
//    private Order order;


//    public OrderLine(ProductDto productDto, int quantity) {
//        this.productDto = productDto;
//        this.quantity = quantity;
//    }
}
