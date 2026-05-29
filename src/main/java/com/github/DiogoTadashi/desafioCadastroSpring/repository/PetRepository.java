package com.github.DiogoTadashi.desafioCadastroSpring.repository;

import com.github.DiogoTadashi.desafioCadastroSpring.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
