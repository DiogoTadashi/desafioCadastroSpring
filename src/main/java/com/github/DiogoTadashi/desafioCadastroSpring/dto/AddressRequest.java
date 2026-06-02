package com.github.DiogoTadashi.desafioCadastroSpring.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(

    String houseNumber,

    @NotBlank
    String city,

    @NotBlank
    String street

) {}