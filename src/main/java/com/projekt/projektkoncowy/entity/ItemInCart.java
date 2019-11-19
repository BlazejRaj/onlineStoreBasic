package com.projekt.projektkoncowy.entity;

import com.projekt.projektkoncowy.dto.ProductDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class ItemInCart {

    private ProductDto productDto;

    private int quantity;

    public ItemInCart(ProductDto productDto, int quantity) {
        this.productDto = productDto;
        this.quantity = quantity;
    }
}
