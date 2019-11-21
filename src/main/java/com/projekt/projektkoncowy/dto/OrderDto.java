package com.projekt.projektkoncowy.dto;

import com.projekt.projektkoncowy.entity.OrderLine;
import com.projekt.projektkoncowy.entity.User;
import lombok.Data;


@Data
public class OrderDto {

    //private Long id;

    private String date;

    private User user;

   // private OrderLine orderLine;

}
