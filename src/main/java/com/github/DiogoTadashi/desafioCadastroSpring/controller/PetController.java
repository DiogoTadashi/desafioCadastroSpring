package com.github.DiogoTadashi.desafioCadastroSpring.controller;

import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
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
    public ResponseEntity<Pet> save(@RequestBody @Valid Pet pet) {
        return ResponseEntity.status(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Pet>> findAll() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Pet>> findById(@PathVariable Long id) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> update(@PathVariable Long id, @RequestBody @Valid Pet pet) {

    }
}
