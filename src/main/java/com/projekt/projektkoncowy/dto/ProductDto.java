package com.projekt.projektkoncowy.dto;


import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ProductDto {

    private Long id;

    @Size(min = 2, max =20)
    private String title;

    @Size(min = 2, max =255)
    private String description;

    private String prize;
}
