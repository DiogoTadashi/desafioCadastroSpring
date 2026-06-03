package com.github.DiogoTadashi.desafioCadastroSpring.dto;

import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;

import java.time.LocalDateTime;

public record PetResponse(
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
        String breed,
        LocalDateTime dateRegister)
{
    public static PetResponse from(Pet pet) {
        return new PetResponse(
                pet.getId(),
                pet.getName(),
                pet.getLastName(),
                pet.getTypePet(),
                pet.getSexPet(),
                pet.getAddress().getCity(),
                pet.getAddress().getStreet(),
                pet.getAddress().getHouseNumber(),
                pet.getAge(),
                pet.getWeight(),
                pet.getBreed(),
                pet.getDateRegister()
        );
    }
}
