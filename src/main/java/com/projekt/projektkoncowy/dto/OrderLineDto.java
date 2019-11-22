package com.projekt.projektkoncowy.dto;

import com.projekt.projektkoncowy.entity.Order;
import com.projekt.projektkoncowy.entity.Product;
import lombok.Data;




@Data
public class OrderLineDto {


    private Long id;

    private int quantity;

    private ProductDto productDto;

  //  private Order order;

}
