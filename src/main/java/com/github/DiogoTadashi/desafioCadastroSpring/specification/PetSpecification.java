package com.github.DiogoTadashi.desafioCadastroSpring.specification;

import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;
import org.springframework.data.jpa.domain.Specification;

public final class PetSpecification {
    public static Specification<Pet> nameContains(String name) {
        return (root, query, cb) -> cb.like
                (cb.lower(root.get("name")),
                "%" + name.toLowerCase() + "%"
                );
    }

    public static Specification<Pet> lastNameContains(String lastName) {
        return (root, query, cb) -> cb.like(
                cb.lower(root.get("lastName")),
                "%" + lastName.toLowerCase() + "%"
        );
    }

    public static Specification<Pet> typeEquals(TypePet typePet) {
        return (root, query, cb) -> cb.equal(root.get("typePet"), typePet);
    }

    public static Specification<Pet> sexEquals(SexPet sexPet){
        return (root, query, cb) -> cb.equal(root.get("sexPet"),sexPet);
    }

    public static Specification<Pet> cityContains(String city) {
        return (root, query, cb) -> cb.like(
                        cb.lower(root.get("address").get("city")),
                        "%" + city.toLowerCase() + "%"
                );
    }

    public static Specification<Pet> streetContains(String street) {
        return (root, query, cb) ->
                cb.like(
                        cb.lower(root.get("address").get("street")),
                        "%" + street.toLowerCase() + "%"
                );
    }

    public static Specification<Pet> houseNumberEquals(String houseNumber) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("address").get("houseNumber"),
                        houseNumber
                );
    }

    public static Specification<Pet> ageEquals(Integer age) {
        return (root, query, cb) -> cb.equal(root.get("age"), age);
    }

    public static Specification<Pet> weightEquals(Double weight) {
        return (root, query, cb) -> cb.equal(root.get("weight"), weight);
    }

    public static Specification<Pet> breedContains(String breed) {
        return (root, query, cb) -> cb.like(
                cb.lower(root.get("breed")),
                "%" + breed.toLowerCase() + "%");
    }
}
