package com.projekt.projektkoncowy.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotBlank
    @Size(min = 2, max =20)
    private String username;

    @NotBlank
    @Size(min = 2, max =20)
    private String firstName;

    @NotBlank
    @Size(min = 2, max =20)
    private String password;

}
