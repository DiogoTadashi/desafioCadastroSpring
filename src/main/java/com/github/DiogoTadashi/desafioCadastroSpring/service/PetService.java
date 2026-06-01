package com.github.DiogoTadashi.desafioCadastroSpring.service;

import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
import com.github.DiogoTadashi.desafioCadastroSpring.exception.PetNotFoundException;
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
        validatePet(pet);
        return repository.save(pet);
    }

    public Pet update(Long id, Pet petUpdated) {
        //Fazer
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Pet not found with ID: " + id);
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

    private void validatePet(Pet pet) {
        //Fazer
    }
}
