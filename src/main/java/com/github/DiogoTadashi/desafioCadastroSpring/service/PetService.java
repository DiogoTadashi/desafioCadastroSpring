package com.github.DiogoTadashi.desafioCadastroSpring.service;

import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
import com.github.DiogoTadashi.desafioCadastroSpring.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public Pet save(Pet pet) {
        return repository.save(pet);
    }

    public List<Pet> findAll() {
        return repository.findAll();
    }

    public Pet deleteById(Long id) {
        return repository.deleteAllById(id);
    }
}
