package com.projekt.projektkoncowy.dto;

import com.projekt.projektkoncowy.entity.Order;
import com.projekt.projektkoncowy.entity.Product;
import lombok.Data;


@Data
public class OrderLineDto {


  //  private Long id;

    private Product product;

    private int quantity;

    private Order order;


}
