package com.github.DiogoTadashi.desafioCadastroSpring.service;

import com.github.DiogoTadashi.desafioCadastroSpring.dto.AddressRequest;
import com.github.DiogoTadashi.desafioCadastroSpring.dto.PetRequest;
import com.github.DiogoTadashi.desafioCadastroSpring.dto.PetResponse;
import com.github.DiogoTadashi.desafioCadastroSpring.entity.Address;
import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.AgeUnit;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;
import com.github.DiogoTadashi.desafioCadastroSpring.exception.PetNotFoundException;
import com.github.DiogoTadashi.desafioCadastroSpring.exception.PetValidationException;
import com.github.DiogoTadashi.desafioCadastroSpring.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {
    @Mock
    private PetRepository repository;

    @InjectMocks
    private PetService service;

    private Pet pet;
    private Address address;

    @BeforeEach
    void setUp(){
        address = new Address("3054", "Jales", "Rua 14");
        pet = Pet.builder()
                .id(1L)
                .name("Nina")
                .lastName("Amorim")
                .typePet(TypePet.DOG)
                .sexPet(SexPet.FEMALE)
                .address(address)
                .age(10.0)
                .weight(15.5)
                .breed("Shitzu")
                .build();
    }

    // ─── SAVE ────────────────────────────────────────────────
    @Test
    @DisplayName("Should save pet successfully")
    void savePetSuccess() {
        // ARRANGE
        PetRequest request = new PetRequest(
                "Nina",
                "Amorim",
                TypePet.DOG,
                SexPet.FEMALE,
                new AddressRequest("123", "Jales", "Rua 14"),
                10.0,
                AgeUnit.YEARS,
                15.5,
                "Shitzu"
        );
        when(repository.save(any(Pet.class))).thenReturn(pet);

        // ACT
        PetResponse response = service.save(request);

        // ASSERT
        assertThat(response.name()).isEqualTo("Nina");
        assertThat(response.id()).isEqualTo(1L);
    }

    @Test
    @DisplayName("Should throw PetValidationException when name has numbers")
    void saveInvalidName() {
        // ARRANGE
        PetRequest request = new PetRequest(
                "123",
                "Amorim",
                TypePet.DOG,
                SexPet.FEMALE,
                new AddressRequest("123", "Jales", "Rua 14"),
                10.0,
                AgeUnit.YEARS,
                15.5,
                "Shitzu"
        );

        // ACT & ASSERT
        assertThrows(PetValidationException.class, () -> service.save(request));
    }

    @Test
    @DisplayName("Should throw PetValidationException when last name has numbers")
    void saveInvalidLastName() {
    }

    @Test
    @DisplayName("Should throw PetValidationException when weight is below 0.5")
    void saveWeightTooLow() {
    }

    @Test
    @DisplayName("Should throw PetValidationException when weight is above 60")
    void saveWeightTooHigh() {
    }

    @Test
    @DisplayName("Should throw PetValidationException when age is above 20 years")
    void saveAgeTooHighYears() {
    }

    @Test
    @DisplayName("Should throw PetValidationException when age is above 240 months")
    void saveAgeTooHighMonths() {
    }

    // ─── UPDATE ──────────────────────────────────────────────
    @Test
    @DisplayName("Should update pet successfully")
    void updatePetSuccess() {
    }

    @Test
    @DisplayName("Should throw PetNotFoundException when updating non existing pet")
    void updatePetNotFound() {
    }

    @Test
    @DisplayName("Should throw PetValidationException when name is invalid on update")
    void updateInvalidName() {
    }

    // ─── DELETE ──────────────────────────────────────────────
    @Test
    @DisplayName("Should delete pet successfully")
    void deletePetSuccess() {
        // ARRANGE
        when(repository.findById(1L)).thenReturn(Optional.of(pet));

        // ACT
        service.delete(1L);

        // ASSERT
        verify(repository).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw PetNotFoundException when deleting non existing pet")
    void deletePetNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PetNotFoundException.class, () -> service.delete(1L));
    }

    // ─── FIND ALL ────────────────────────────────────────────
    @Test
    @DisplayName("Should return list of pets")
    void findAllReturnsList() {
    }

    @Test
    @DisplayName("Should return empty list when no pets exist")
    void findAllReturnsEmpty() {
        when(repository.findAll()).thenReturn(List.of());

        List<PetResponse> response = service.findAll();

        assertThat(response).isEmpty();
    }

    // ─── FIND BY ID ──────────────────────────────────────────
    @Test
    @DisplayName("The response must match the requested ID")
    void findById() {
        when(repository.findById(1L)).thenReturn(Optional.of(pet));

        PetResponse response = service.findById(1L);

        assertThat(response.id()).isEqualTo(1L);
        assertThat(response.name()).isEqualTo("Nina");
    }

    @Test
    @DisplayName("Should throw PetNotFoundException when pet not found")
    void findByIdNotFound() {
    }

    // ─── FIND BY CRITERIA ────────────────────────────────────
    @Test
    @DisplayName("Should return pets filtered by name")
    void findByCriteriaByName() {
    }

    @Test
    @DisplayName("Should return empty list when no pets match criteria")
    void findByCriteriaEmpty() {
    }
}