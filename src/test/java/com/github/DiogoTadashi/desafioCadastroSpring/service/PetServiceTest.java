package com.github.DiogoTadashi.desafioCadastroSpring.service;

import com.github.DiogoTadashi.desafioCadastroSpring.dto.PetResponse;
import com.github.DiogoTadashi.desafioCadastroSpring.entity.Address;
import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;
import com.github.DiogoTadashi.desafioCadastroSpring.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {
    @Mock
    private PetRepository repository;

    @InjectMocks
    private PetService service;

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        // ARRANGE
        Address address = new Address(
                "123",
                "Rio Preto",
                "Rua A"
        );
        Pet pet = Pet.builder()
                .id(1L)
                .name("Nina")
                .lastName("Amorim")
                .typePet(TypePet.DOG)
                .sexPet(SexPet.FEMALE)
                .address(address)
                .age(10.0)
                .weight(15.5)
                .breed("Labrador")
                .build();

        when(repository.findById(1L)).thenReturn(Optional.of(pet));

        // ACT — executa o método
        PetResponse response = service.findById(1L);

        // ASSERT — verifica o resultado
        assertThat(response.id()).isEqualTo(1L);
        assertThat(response.name()).isEqualTo("Nina");

    }

    @Test
    void findByCriteria() {
    }
}