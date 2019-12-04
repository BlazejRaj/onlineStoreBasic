package com.projekt.projektkoncowy.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class AddressDto {

    private Long id;

    @Size(min = 2, max =20)
    private String name;

    @Size(min = 2, max =20)
    private String surname;

    @Size(min = 2, max =20)
    private String country;

    @Size(min = 2, max =20)
    private String city;

    @Size(min = 2, max =30)
    private String street;

    @Size(min = 1, max =10)
    private String houseNo;

    @Size(min = 1, max =10)
    private String postalCode;

}
