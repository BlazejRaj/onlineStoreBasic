package com.projekt.projektkoncowy.dto;

import lombok.Data;

import java.util.List;

@Data
public class Cart {

    private List<ItemInCart> itemInCartList;

    private String username;





}
