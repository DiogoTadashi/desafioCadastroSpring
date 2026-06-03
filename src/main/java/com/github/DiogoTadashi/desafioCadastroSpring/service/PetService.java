package com.github.DiogoTadashi.desafioCadastroSpring.service;

import com.github.DiogoTadashi.desafioCadastroSpring.constants.PetConstants;
import com.github.DiogoTadashi.desafioCadastroSpring.dto.PetRequest;
import com.github.DiogoTadashi.desafioCadastroSpring.entity.Address;
import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.AgeUnit;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;
import com.github.DiogoTadashi.desafioCadastroSpring.exception.PetNotFoundException;
import com.github.DiogoTadashi.desafioCadastroSpring.exception.PetValidationException;
import com.github.DiogoTadashi.desafioCadastroSpring.repository.PetRepository;
import com.github.DiogoTadashi.desafioCadastroSpring.specification.PetSpecification;
import org.springframework.data.jpa.domain.Specification;
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
        Pet pet = findById(id);

        Address address = new Address(
                defaultString(request.address().houseNumber()),
                request.address().city(),
                request.address().street()
        );

        pet.setName(request.name());
        pet.setLastName(request.lastName());
        pet.setAddress(address);
        pet.setBreed(defaultString(request.breed()));
        pet.setAge(convertAge(
                request.age(),
                request.ageUnit()
        ));
        pet.setWeight(request.weight());

        validatePet(pet, request.ageUnit());

        return repository.save(pet);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
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
    public List<Pet> findByCriteria(String name, String lastName, TypePet typePet, SexPet sexPet,
                                    String city, String street, String houseNumber, Double age,
                                    Double weight, String breed) {
        Specification<Pet> spec = Specification.unrestricted();

        if (name != null) spec = spec.and(PetSpecification.nameContains(name));
        if (lastName != null) spec = spec.and(PetSpecification.lastNameContains(lastName));
        if (typePet != null) spec = spec.and(PetSpecification.typeEquals(typePet));
        if (sexPet != null) spec = spec.and(PetSpecification.sexEquals(sexPet));
        if (city != null) spec = spec.and(PetSpecification.cityContains(city));
        if (street != null) spec = spec.and(PetSpecification.streetContains(street));
        if (houseNumber != null) spec = spec.and(PetSpecification.houseNumberEquals(houseNumber));
        if (age != null) spec = spec.and(PetSpecification.ageEquals(age));
        if (weight != null) spec = spec.and(PetSpecification.weightEquals(weight));
        if (breed != null) spec = spec.and(PetSpecification.breedContains(breed));

        return repository.findAll(spec);
    }

    private static final String NAME_REGEX = "^[a-zA-ZÀ-ÿ ]+$";

    private void validatePet(Pet pet, AgeUnit ageUnit) {
        if (!pet.getName().matches(NAME_REGEX)) {
            throw new PetValidationException("Pet name characters only accepted");
        }
        if (!pet.getLastName().matches(NAME_REGEX)) {
            throw new PetValidationException("Last name characters only accepted");
        }
        if (pet.getAge() != null &&
                ((pet.getAge() > 20 && ageUnit == AgeUnit.YEARS)
                        || (pet.getAge() > 240 && ageUnit == AgeUnit.MONTHS))) {
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
