package com.github.DiogoTadashi.desafioCadastroSpring.service;

import com.github.DiogoTadashi.desafioCadastroSpring.constants.PetConstants;
import com.github.DiogoTadashi.desafioCadastroSpring.dto.PetRequest;
import com.github.DiogoTadashi.desafioCadastroSpring.entity.Address;
import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.AgeUnit;
import com.github.DiogoTadashi.desafioCadastroSpring.exception.PetNotFoundException;
import com.github.DiogoTadashi.desafioCadastroSpring.exception.PetValidationException;
import com.github.DiogoTadashi.desafioCadastroSpring.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public Pet save(PetRequest request) {

        Address address = new Address(
                defaultString(request.address().houseNumber()),
                request.address().city(),
                request.address().street()
        );

        Pet pet = Pet.builder()
                .name(request.name())
                .lastName(request.lastName())
                .typePet(request.typePet())
                .sexPet(request.sexPet())
                .address(address)
                .breed(defaultString(request.breed()))
                .age(convertAge(request.age(), request.ageUnit()))
                .weight(request.weight())
                .build();

        validatePet(pet, request.ageUnit());

        return repository.save(pet);
    }

    public Pet update(Long id, PetRequest request) {
        //Fazer
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new PetNotFoundException("Pet not found with ID: " + id);
        }
    }

    public List<Pet> findAll() {
        return repository.findAll();
    }

    public Pet findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new PetNotFoundException(
                        "Pet not found with id: " + id
        ));
    }

    public List<Pet> findByCriteria(){
        //Fazer
    }

    private static final String NAME_REGEX = "^[a-zA-ZÀ-ÿ ]+$";

    private void validatePet(Pet pet, AgeUnit ageUnit) {
        if (!pet.getName().matches(NAME_REGEX)) {
            throw new PetValidationException("Pet name characters only accepted");
        }
        if (!pet.getLastName().matches(NAME_REGEX)) {
            throw new PetValidationException("Last name characters only accepted");
        }
        if (pet.getWeight() != null &&
                (pet.getWeight() < 0.5 || pet.getWeight() > 60)) {
            throw new PetValidationException("Weight must be between 0.5kg and 60kg");
        }
        if (pet.getAge() != null &&
                (pet.getAge() > 20 && ageUnit == AgeUnit.YEARS)) {
            throw new PetValidationException("Age must be below 20 years");
        }
    }

    private Double convertAge(Double age, AgeUnit ageUnit) {
        if (age == null) {
            return null;
        }

        if(ageUnit == AgeUnit.MONTHS) {
            return age / 12.0;
        }

        return age;
    }

    private String defaultString(String value) {

        if (value == null || value.isBlank()) {
            return PetConstants.NOT_INFORMED;
        }

        return value;
    }
}
