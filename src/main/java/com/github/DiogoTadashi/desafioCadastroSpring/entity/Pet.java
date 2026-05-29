package com.github.DiogoTadashi.desafioCadastroSpring.entity;

import com.github.DiogoTadashi.desafioCadastroSpring.enums.SexPet;
import com.github.DiogoTadashi.desafioCadastroSpring.enums.TypePet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sobrenome;

    @Enumerated(EnumType.STRING)
    private TypePet tipo;

    @Enumerated(EnumType.STRING)
    private SexPet sexo;

    @Embedded
    private Address address;

    private Double idade;
    private Double peso;
    private String raca;

    @CreationTimestamp
    private LocalDateTime dataCadastro;
}
