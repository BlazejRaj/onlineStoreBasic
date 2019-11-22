package com.projekt.projektkoncowy.dto;

import com.projekt.projektkoncowy.entity.OrderLine;
import com.projekt.projektkoncowy.entity.User;
import lombok.Data;


import java.util.List;
import java.util.Set;


@Data
public class OrderDto {

    private Long id;

    private String date;

    private List<OrderLine> orderLines;

    private User user;

}
