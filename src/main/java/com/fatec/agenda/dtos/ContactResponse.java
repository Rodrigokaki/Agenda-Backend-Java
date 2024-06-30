package com.fatec.agenda.dtos;

public record ContactResponse(int id, String name, Integer age, Integer gender, String telephone, Boolean favorite) {
    
}
