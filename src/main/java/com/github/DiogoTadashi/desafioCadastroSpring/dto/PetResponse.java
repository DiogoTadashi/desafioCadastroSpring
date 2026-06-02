package com.github.DiogoTadashi.desafioCadastroSpring.dto;

import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;

public record PetResponse() {
    Long id,
    String name,
    String lastName,
    TypePet typePet,
    SexPet sexPet,

    String city,
    String street,
    String houseNumber,

    Double age,
    Double weight,

    String breed
}
