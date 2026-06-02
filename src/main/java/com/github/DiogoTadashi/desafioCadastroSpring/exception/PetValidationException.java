package com.github.DiogoTadashi.desafioCadastroSpring.exception;

public class PetValidationException extends RuntimeException {
    public PetValidationException(String message) {
        super(message);
    }
}