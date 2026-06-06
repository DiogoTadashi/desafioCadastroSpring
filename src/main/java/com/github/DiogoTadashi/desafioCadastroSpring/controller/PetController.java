package com.github.DiogoTadashi.desafioCadastroSpring.controller;

import com.github.DiogoTadashi.desafioCadastroSpring.dto.PetRequest;
import com.github.DiogoTadashi.desafioCadastroSpring.dto.PetResponse;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;
import com.github.DiogoTadashi.desafioCadastroSpring.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("")
    public ResponseEntity<PetResponse> save(@RequestBody @Valid PetRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.save(request));
    }

    @GetMapping("")
    public ResponseEntity<List<PetResponse>> findAll() {
        List<PetResponse> petList = petService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(petList);
    }

    @GetMapping("")
    public ResponseEntity<List<PetResponse>> findByCriteria(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) TypePet typePet,
            @RequestParam(required = false) SexPet sexPet,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String street,
            @RequestParam(required = false) String houseNumber,
            @RequestParam(required = false) Double age,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) String breed) {
        List<PetResponse> petList = petService.findByCriteria(
                name, lastName, typePet, sexPet,
                city, street, houseNumber, age, weight, breed);

        return ResponseEntity.status(HttpStatus.OK).body(petList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponse> findById(@PathVariable Long id) {
        PetResponse pet = petService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetResponse> update(@PathVariable Long id, @RequestBody @Valid PetRequest request) {
        PetResponse pet = petService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        petService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
