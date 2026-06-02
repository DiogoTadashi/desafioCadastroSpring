package com.github.DiogoTadashi.desafioCadastroSpring.dto;

import com.github.DiogoTadashi.desafioCadastroSpring.enums.AgeUnit;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

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

        @DecimalMin("0.5")
        @DecimalMax("60.0")
        Double weight,

        String breed

) {
}