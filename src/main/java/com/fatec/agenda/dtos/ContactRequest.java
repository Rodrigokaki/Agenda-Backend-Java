package com.fatec.agenda.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactRequest(
    @NotBlank(message = "O nome não pode ser nulo")
    String name, 
    
    @NotNull(message = "A idade não pode ser nula")
    Integer age, 
    
    @NotNull(message = "O sexo não pode ser nulo")
    Integer gender, 
    
    @NotBlank(message = "O telefone não pode ser nulo")
    String telephone, 
    
    @NotNull(message = "Favorito obrigatório")
    Boolean favorite) {
    
}
