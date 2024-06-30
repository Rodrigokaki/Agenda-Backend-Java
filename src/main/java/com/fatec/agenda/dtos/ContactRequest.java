package com.fatec.agenda.dtos;

import jakarta.validation.constraints.NotBlank;

public record ContactRequest(
    @NotBlank(message = "O nome não pode ser nulo")
    String name, 

    Integer age, 
    
    Integer gender, 
    
    @NotBlank(message = "O telefone não pode ser nulo")
    String telephone, 
    
    Boolean favorite) {
    
}
