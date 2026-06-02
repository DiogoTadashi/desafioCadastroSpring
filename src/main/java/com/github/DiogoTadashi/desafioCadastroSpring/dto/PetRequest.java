package com.github.DiogoTadashi.desafioCadastroSpring.dto;

import com.github.DiogoTadashi.desafioCadastroSpring.enums.AgeUnit;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PetRequest(
        @NotBlank
        String name,

        @NotBlank
        String lastName,

        @NotNull
        TypePet typePet,

        @NotNull
        SexPet sexPet,

        @NotNull
        @Valid
        AddressRequest address,

        @PositiveOrZero
        Double age,

        @NotNull
        AgeUnit ageUnit,

        @PositiveOrZero
        Double weight,

        String breed

) {
}